import com.sun.jdi.event.StepEvent;

import java.io.*;
import java.util.*;

public class RegularBracketSequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < n - i; j++) {
                    sb.append('(');
                }
                for (int j = 0; j < i; j++) {
                    sb.append("()");
                }
                for (int j = 0; j < n - i; j++) {
                    sb.append(")");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
