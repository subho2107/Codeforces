import java.io.*;
import java.util.*;

public class ConstructTheString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), a = Integer.parseInt(inp[1]), b = Integer.parseInt(inp[2]);
            StringBuilder res = new StringBuilder();
            if (b != a) {
                for (int pos = 0; pos < b; pos++) {
                    res.append((char) (97 + pos%26));
                }
                char last = res.charAt(res.length() - 1);
                for (int pos = 0; pos < a - b; pos++) {
                    res.append(last);
                }
                while (res.length() < n) {
                    res.append(res.charAt(res.length() - a));
                }
            } else {
                for (int pos = 0; pos < n; pos++) {
                    res.append((char) (97 + pos%26));
                }
            }
            sb.append(res.toString() + "\n");
        }
        System.out.println(sb);
    }
}
