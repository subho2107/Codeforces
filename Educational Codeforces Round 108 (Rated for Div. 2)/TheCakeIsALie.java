import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheCakeIsALie {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().
                    split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
            if (Math.min(m*(n-1)+m-1, n*(m-1)+n-1) == k)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
