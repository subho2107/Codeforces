import java.io.*;
import java.util.*;

public class CPlusEqualTo {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[]inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), n = Integer.parseInt(inp[2]);
            int cnt = 0;
//            int temp = a;
//            a = Math.min(a, b);
//            b = Math.max(b, temp);
            while (a <= n && b <= n)
            {
                if(a<b)a+=b;
                else b+=a;
                cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
