import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ANDSequences {
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
            int and = arr[0];
            for (int i = 0; i < n; i++) {
                and &= arr[i];
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == and)
                    cnt++;
            }
            int MOD = 1_000_000_007;
            long ans = (long) cnt*(cnt-1);
            ans %= MOD;
            for (int i = 2; i < n - 1; i++) {
                ans *= i;
                ans %= MOD;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
