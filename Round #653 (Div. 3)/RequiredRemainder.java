import java.io.*;
import java.util.*;

public class RequiredRemainder {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]), n = Integer.parseInt(inp[2]);
            int num = n/x;
            if (num*x+y <= n)
                sb.append((num*x+y)+"\n");
            else
                sb.append(((num-1)*x+y)+"\n");
        }
        System.out.println(sb);
    }
}
