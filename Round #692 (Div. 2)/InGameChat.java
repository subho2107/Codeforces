import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InGameChat {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            int cnt = 0;
            for (int i = n-1; i >=0 && s.charAt(i) == ')' ; i--) {
                cnt++;
            }
            if (cnt > n - cnt)
                sb.append("Yes\n");
            else
                sb.append("No\n");
        }
        System.out.println(sb);
    }
}
