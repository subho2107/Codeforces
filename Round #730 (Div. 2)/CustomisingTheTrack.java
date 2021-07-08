import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomisingTheTrack {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long [] arr = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                sum += arr[i];
            }
            long mod = sum%n;
            long ans = mod*(n-mod);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
