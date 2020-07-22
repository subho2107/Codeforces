import java.io.*;
import java.util.*;

public class CommonSubsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] a = new int[n];
            int [] b = new int[m];
            HashSet<Integer> ah = new HashSet<>();
            for (int pos = 0; pos < n; pos++) {
                a[pos] = Integer.parseInt(inp[pos]);
                ah.add(a[pos]);
            }
            boolean check = false;
            int num = -1;
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < m; pos++) {
                b[pos] = Integer.parseInt(inp[pos]);
                if (ah.contains(b[pos])) {
                    check = true;
                    num = b[pos];
                }
            }
            if (check)
            {
                sb.append("YES\n");
                sb.append("1 "+num+"\n");
            }
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
