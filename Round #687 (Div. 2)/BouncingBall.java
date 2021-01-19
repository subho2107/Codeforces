import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BouncingBall {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), p = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
            char[] state = buffer.readLine().toCharArray();
            inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
            long[] dp = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                if (state[i] == '0')
                    dp[i] += x;
                if (i + k < n)
                    dp[i] += dp[i + k];
            }

            long minVal = Integer.MAX_VALUE;
            for (int i = 0; i < n && i+p-1 < n; i++) {
                long currCost = (long) i*y+dp[i+p-1];
                minVal = Math.min(minVal, currCost);
            }
            sb.append(minVal+"\n");
        }
        System.out.println(sb);
    }
}
