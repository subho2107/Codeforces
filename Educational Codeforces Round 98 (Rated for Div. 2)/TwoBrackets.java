import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoBrackets {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            char [] s = buffer.readLine().toCharArray();
            int first = 0, third = 0;
            int cnt = 0;
            for (char ch : s) {
                if ((ch == ']' && third == 0)||(ch == ')' && first == 0))
                    continue;
                if (ch == '[')third++;
                else if (ch == '(')first++;
                else if (ch == ']')
                {
                    third--;
                    cnt++;
                }
                else if (ch == ')'){
                    first--;
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
