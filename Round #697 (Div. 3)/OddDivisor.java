import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OddDivisor {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(buffer.readLine());
            while (n % 2 == 0)
                n /= 2;
            if (n  == 1)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
