import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheSportsFestival {
    public static long getAns(int l, int r, int [] arr, long [][] dp){
        if (l == r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        return dp[l][r] = arr[r]-arr[l]+Math.min(getAns(l+1, r, arr, dp), getAns(l, r-1, arr, dp));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            long [][] dp = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            long ans = getAns(0, n-1, arr, dp);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
