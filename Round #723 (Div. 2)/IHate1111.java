import java.io.BufferedReader;
import java.io.InputStreamReader;
public class IHate1111 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            if (n > 1099){
                sb.append("YES\n");
                continue;
            }
            boolean check = false;
            for (int i = 0; i*11 <= n; i++) {
                for (int j = 0; j*111 <= n; j++) {
                    if (11*i+111*j == n){
                        check = true;
                        break;
                    }
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
