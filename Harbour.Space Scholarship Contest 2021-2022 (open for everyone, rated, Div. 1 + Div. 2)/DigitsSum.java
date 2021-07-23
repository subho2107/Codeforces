import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DigitsSum {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int ans = (n/10);
            if (n % 10 == 9)
                ans++;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
