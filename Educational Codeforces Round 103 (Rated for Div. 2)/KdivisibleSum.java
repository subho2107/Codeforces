import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KdivisibleSum {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int ans;
            if (k >= n) {
                ans = k / n;
                if (k % n != 0)
                    ans++;
            } else {
                ans = 1;
                if (n % k != 0)
                    ans++;
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
