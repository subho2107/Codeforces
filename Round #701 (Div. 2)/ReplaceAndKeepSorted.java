import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReplaceAndKeepSorted {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            long [] pref = new long[n];
            pref[0] = arr[0]-1;
            pref[n-1] += k-arr[n-1];
            if (n > 1) {
                pref[0] += arr[1] - arr[0] - 1;
                pref[n-1] += arr[n-1]-arr[n-2]-1;
            }

            for (int i = 1; i < n-1; i++) {
                pref[i] = arr[i]-arr[i-1]-1 + arr[i+1] - arr[i]-1;
            }
            for (int i = 1; i < n; i++) {
                pref[i] += pref[i-1];
            }
            for (int i = 0; i < q; i++) {
                inp = buffer.readLine().split(" ");
                int l = Integer.parseInt(inp[0])-1, r = Integer.parseInt(inp[1])-1;
                long sum = l == 0?pref[r]:pref[r]-pref[l-1];
                if (l != 0)
                    sum += arr[l-1];
                if (r != n-1)
                    sum += k - arr[r+1] + 1;
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }
}
