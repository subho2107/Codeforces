import java.io.*;
import java.util.*;

public class ThreePairwiseMaximums {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]), z = Integer.parseInt(inp[2]);
            int [] a = {x, y, z};
            Arrays.sort(a);
            if (a[2]!=a[1] && a[2]!=a[0])
                sb.append("NO\n");
            else
            {
                sb.append("YES\n");
                if (x==y && y==z && x==z) {
                    sb.append(x + " " + y + " " + z + "\n");
                    continue;
                }
                x = a[0];
                y = a[1];
                z = a[2];
                sb.append(1+" ");
                sb.append(z+" ");
                int temp = z==y?x:y;
                sb.append(temp+"\n");
            }
        }
        System.out.println(sb);
    }
}
