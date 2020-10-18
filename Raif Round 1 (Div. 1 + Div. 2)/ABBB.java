import java.io.BufferedReader;
import java.io.InputStreamReader;
import  java.util.*;
public class ABBB {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            char [] arr = buffer.readLine().toCharArray();
            Stack<Character>stack = new Stack<>();
            for (char c : arr) {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    char ch = stack.peek();
                    if (ch == 'A' && c == 'B')
                        stack.pop();
                    else if (ch == 'B' && c == 'B')
                        stack.pop();
                    else
                        stack.push(c);
                }
            }
            sb.append(stack.size()+"\n");
        }
        System.out.println(sb);
    }
}
