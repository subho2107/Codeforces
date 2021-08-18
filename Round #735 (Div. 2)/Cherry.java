import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cherry {
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
            long ans = 0;
            for (int i = 0; i < n - 1; i++) {
                ans = Math.max(ans, (long) arr[i]*arr[i+1]);
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
