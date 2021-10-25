import java.io.*;
import java.util.*;

public class TwoSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            int pos = -1, smallestCh = 'z';
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) <= smallestCh){
                   smallestCh = s.charAt(i);
                   pos = i;
                }
            }
            sb.append(s.charAt(pos)+" ");
            for (int i = 0; i < s.length(); i++) {
                if (i == pos)
                    continue;
                sb.append(s.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
