import java.io.*;
import java.util.*;

public class ACookieForYou {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long  a = Long.parseLong(inp[0]), b = Long.parseLong(inp[1]), n = Long.parseLong(inp[2]), m = Long.parseLong(inp[3]);
            if (Math.min(a, b) < m||a+b<m+n)
                sb.append("NO\n");
            else
                sb.append("YES\n");

        }
        System.out.println(sb);
    }
}
