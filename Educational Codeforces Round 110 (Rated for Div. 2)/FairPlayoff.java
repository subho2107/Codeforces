import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FairPlayoff {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]), d = Integer.parseInt(inp[3]);
            int [] arr = {a, b, c , d};
            Arrays.sort(arr);
            int e = Math.max(a, b), f = Math.max(c, d);
            if ((e == arr[2] && f == arr[3]) || (e == arr[3] && f == arr[2]))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
