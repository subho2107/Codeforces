import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreeSwimmers {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long p = Long.parseLong(inp[0]), a = Long.parseLong(inp[1]), b = Long.parseLong(inp[2]), c = Long.parseLong(inp[3]);
            long i = p/a, j = p/b, k = p/c;
            if (i*a < p)
                i++;
            if (j*b < p)
                j++;
            if (k*c < p)
                k++;
            long ans = Math.min(i*a, Math.min(j*b, k*c)) - p;
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
