import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AquaMoonAndStolenString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [][] dp = new int[m][26];
            for (int i = 0; i < n; i++) {
                char [] arr = buffer.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    dp[j][arr[j] - 'a']++;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                char [] arr = buffer.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    dp[j][arr[j] - 'a']++;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][j] % 2 == 1){
                        sb.append((char) ('a'+j));
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.flush();
    }
}
