import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreatGraphs {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long [] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            for (int i = 1; i < n; i++) {
                arr[i] += arr[i-1];
            }
            long ans = 0;
            for (int i = 2; i < n; i++) {
                ans -= (i-1)*(arr[i]-arr[i-1])-arr[i-2];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}