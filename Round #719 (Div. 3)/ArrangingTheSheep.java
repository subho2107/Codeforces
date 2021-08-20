import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrangingTheSheep {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            long ans = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (i+1 < n && s.charAt(i) == '*' && s.charAt(i+1) == '.')
                {
                    cnt = 0;
                    i++;
                    while (i < n && s.charAt(i) == '.')
                    {
                        cnt++;
                        i++;
                    }
                    if (i < n && s.charAt(i) == '*')
                    ans = Math.max(ans, (long) cnt *cnt);
                    i--;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
