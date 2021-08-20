import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DoNotBeDistracted {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            boolean [] check = new boolean[26];
            boolean ans = false;
            for (int i = 0; i < n-1; i++) {
                if (s.charAt(i) != s.charAt(i+1)){
                    check[s.charAt(i) - 'A'] = true;
                }
                if (check[s.charAt(i+1)-'A'])
                {
                    ans = true;
                    break;
                }
            }
            if (ans)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
