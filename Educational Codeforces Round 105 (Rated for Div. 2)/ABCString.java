import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ABCString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            boolean check = false;
            for (int i = 0; i < 8; i++) {
                char valA = '(', valB = '(', valC = '(';
                for (int j = 0; j < 3; j++) {
                    if ((i&(1<<j)) == 0)
                    {
                        if (j == 0)
                            valA = ')';
                        else if (j == 1)
                            valB = ')';
                        else
                            valC = ')';
                    }
                }
                Stack<Character>stack = new Stack<>();
                for (char ch : s.toCharArray()){
                    char curr = ch, peek;
                    if (stack.isEmpty())
                        stack.push(ch);
                    else{
                        curr = curr == 'A'?valA:(curr == 'B'?valB:valC);
                        peek = stack.peek();
                        peek = peek == 'A'?valA:(peek == 'B'?valB:valC);
                        if (peek == '(' && curr == ')')
                            stack.pop();
                        else
                            stack.push(ch);
                    }
                }
                if (stack.isEmpty())
                {
                    check = true;
                    break;
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
