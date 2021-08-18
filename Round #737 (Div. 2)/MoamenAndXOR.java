import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoamenAndXOR {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(Math.pow(2, 1000)%7);
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            if (k == 0){
                sb.append(1+"\n");
                continue;
            }
            long [][] dp = new long[k][2];//0 is win 1 is loss
            int MOD = (int) (1e9+7);
            long [] pow2 = new long[200001];
            pow2[0] = 1;
            for (int i = 1; i < pow2.length; i++) {
                pow2[i] = (pow2[i-1]%MOD*2)%MOD;
            }
            long win, loss;
            win = pow2[n-1]%MOD;
            if (n % 2 == 1)
                win++;
            win %= MOD;
            loss = (pow2[n]%MOD-win%MOD)%MOD;
            dp[0][0] = win%MOD;dp[0][1] = loss%MOD;
            for (int i = 1; i < k; i++) {
                dp[i][0] = (dp[i-1][0]%MOD+dp[i-1][1]%MOD)%MOD;
                dp[i][1] = dp[i][0];
                dp[i][0] = (dp[i][0]%MOD*win%MOD)%MOD;
                dp[i][1] = (dp[i][1]%MOD*loss%MOD)%MOD;
            }
            sb.append(dp[k-1][0]+"\n");
        }
        System.out.println(sb);
    }
}
