import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class NezzarAndSymmetricArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            long [] d = new long[2*n];
            HashMap<Long, Integer>freq = new HashMap<>();
            boolean check = true;
            for (int i = 0; i < 2 * n; i++) {
                d[i] = Long.parseLong(inp[i]);
                if (d[i] % 2 != 0){
                    check = false;
                    break;
                }
                freq.put(d[i], freq.getOrDefault(d[i], 0)+1);
            }
            for (int value : freq.values()) {
                if (value != 2){
                    check = false;
                    break;
                }
            }
            if (!check || freq.size() != n){
                sb.append("NO\n");
                continue;
            }
            Long [] a = new Long[n];
            int i = 0;
            for (long num : freq.keySet()) {
                a[i++] = num/2;
            }
            Arrays.sort(a, Collections.reverseOrder());
            i = n;
            long sum = 0;
            for (int j = 0; j < n; j++) {
                a[j] -= sum;
                if (a[j]%i != 0 || a[j]<=0){
                    check = false;
                    break;
                }
                a[j] /= i--;
                sum += a[j];
            }
            if (!check)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
