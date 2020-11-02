import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MarketingScheme {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int l = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
            if (2*l > r)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
