import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedAndBlue {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long sum = 0, maxR = 0;
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(inp[i]);
                maxR = Math.max(maxR, sum);
            }
            sum = 0;
            long maxB = 0;
            int m = Integer.parseInt(buffer.readLine());
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                sum += Integer.parseInt(inp[i]);
                maxB = Math.max(maxB, sum);
            }
            long ans = maxB + maxR;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
