import java.io.*;
import java.util.*;

public class LuntikAndConcerts {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]);
            long sum = a+b* 2L +c* 3L;
            sb.append(sum%2).append("\n");
        }
        System.out.println(sb);
    }
}
