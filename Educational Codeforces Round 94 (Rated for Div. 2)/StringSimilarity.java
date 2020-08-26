import java.io.*;
import java.util.*;

public class StringSimilarity {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s =buffer.readLine();
            for (int pos = 0; pos < s.length(); pos+=2) {
                sb.append(s.charAt(pos));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
