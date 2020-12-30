import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegularBracketSequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            if (s.length() % 2 == 0 && s.charAt(0) != ')' && s.charAt(s.length() - 1) != '(')
                sb.append("Yes\n");
            else
                sb.append("No\n");
        }
        System.out.println(sb);
    }
}
