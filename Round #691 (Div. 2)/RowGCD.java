import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RowGCD {
    public static long gcd(long a, long b){
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m= Integer.parseInt(inp[1]);
            long [] a = new long[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            long [] b = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(inp[i]);
            }
            if (n == 1){
                for (int i = 0; i < m; i++) {
                    sb.append(a[0]+b[i]).append("\n");
                }
                continue;
            }
            long GCD = Math.abs(a[1] - a[0]);
            Arrays.sort(a);
            for (int i = 1; i < n; i++) {
                GCD = gcd(GCD, Math.abs(a[i]-a[0]));
            }
            for (int i = 0; i < m; i++) {
                sb.append(gcd(GCD, a[0]+b[i])).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
