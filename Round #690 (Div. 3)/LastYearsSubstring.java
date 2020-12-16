import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LastYearsSubstring {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            if (n < 4)
                sb.append("NO\n");
            else {
                if (s.startsWith("2020"))
                    sb.append("YES\n");
                else if (s.substring(n-4).equals("2020"))
                    sb.append("YES\n");
                else {
                    if (s.charAt(0) == '2' && s.substring(n-3).equals("020"))
                        sb.append("YES\n");
                    else if (s.startsWith("20") && s.substring(n-2).equals("20"))
                        sb.append("YES\n");
                    else if (s.startsWith("202") && s.substring(n-1).equals("0"))
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
