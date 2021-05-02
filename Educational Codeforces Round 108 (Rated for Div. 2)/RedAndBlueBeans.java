import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedAndBlueBeans {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int r = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), d = Integer.parseInt(inp[2]);
            int packets = Math.min(r, b);
            int max = Math.max(r, b);
            int maxBeans = max/packets;
            if (max % packets != 0)
                maxBeans++;
            if (maxBeans - 1 > d)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
