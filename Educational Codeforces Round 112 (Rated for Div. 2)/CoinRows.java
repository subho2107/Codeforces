import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinRows {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0)  {
            int m = Integer.parseInt(buffer.readLine());
            int [][] mat = new int[2][m];
            String [] inp;
            for (int i = 0; i < 2; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(inp[j]);
                }
            }
            long [] pref = new long[m+1], suff = new long[m+1];
            for(int i = 1;i <= m; i++)
                pref[i] = pref[i-1]+mat[1][i-1];
            for (int i = m-1; i >= 0; i--)
                suff[i] = suff[i+1]+mat[0][i];
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < m; i++)
                ans = Math.min(ans, Math.max(pref[i], suff[i+1]));
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
