import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloorAndMod {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
            int maxK = (int) Math.sqrt(x);
            long ans = 0;
            for (int i = 1; i <= maxK; i++) {
                ans += Math.max(0, Math.min(y, x/i - 1)-i);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
