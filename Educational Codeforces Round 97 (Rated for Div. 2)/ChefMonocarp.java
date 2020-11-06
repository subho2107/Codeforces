import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefMonocarp {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int [] dp = new int[n + 1];
            Arrays.fill(dp, (int) 1e9);
            dp[0] = 0;
            for (int i = 1; i < 2 * n + 1; i++) {
                for (int j = n; j > 0 ; j--) {
                    dp[j] = Math.min(dp[j], dp[j-1]+Math.abs(arr[j - 1]-i));
                }
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
