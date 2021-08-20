import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeletingDivisors {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int cnt = 0, dup = n;
            while (dup % 2 == 0)
            {
                cnt++;
                dup/=2;
            }
            if (n % 2 == 1 || (dup == 1 && cnt % 2 == 1))
                sb.append("Bob\n");
            else
                sb.append("Alice\n");
        }
        System.out.println(sb);
    }
}
