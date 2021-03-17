import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class DiamondMiner {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<Long>a = new ArrayList<>(), b = new ArrayList<>();
            for (int i = 0; i < 2 * n; i++) {
                String [] inp = buffer.readLine().split(" ");
                long x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
                if (x == 0)
                    a.add(y*y);
                else
                    b.add(x*x);
            }
            Collections.sort(a);
            b.sort(Collections.reverseOrder());
            double ans = 0, ans2 = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.sqrt(a.get(i)+b.get(i));
                ans2 += Math.sqrt(a.get(i)+b.get(n-i-1));
            }
            sb.append(Math.min(ans, ans2)).append("\n");
        }
        System.out.println(sb);
    }
}
