import java.io.*;
import java.util.*;

public class YetAnotherTwoIntegersProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp =buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            int ans = Math.abs(a-b)/10;
            if (Math.abs(a-b)%10 != 0)
                ans++;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
