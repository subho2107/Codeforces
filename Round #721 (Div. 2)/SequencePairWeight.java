import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SequencePairWeight {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inp[i]);
            long [] dp = new long[n];
            HashMap<Integer, Long>map = new HashMap<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (i - 1 >= 0)
                    dp[i] += dp[i-1];
                dp[i] += map.getOrDefault(arr[i], 0L);
                map.put(arr[i], map.getOrDefault(arr[i], 0L)+i+1);
                ans += dp[i];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
