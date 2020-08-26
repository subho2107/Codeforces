import java.io.*;
import java.util.*;

public class BinaryStringReconstruction {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String inp = buffer.readLine();
            int x = Integer.parseInt(buffer.readLine());
            int[] arr = new int[inp.length()];
            for (int pos = 0; pos < arr.length; pos++) {
                arr[pos] = Character.getNumericValue(inp.charAt(pos));
            }
            int[] ans = new int[arr.length];
            Arrays.fill(ans, 1);
            int n = arr.length;
            for (int pos = 0; pos < n; pos++) {
                if (arr[pos] == 0) {
                    if (pos - x >= 0)
                        ans[pos - x] = 0;
                    if (pos + x < n)
                        ans[pos + x] = 0;
                }
            }
            String ansCheck = "";
            for (int pos = 0; pos < n; pos++) {
                if (pos-x>= 0 && ans[pos-x]==1)
                    ansCheck+='1';
                else if (pos+x<n && ans[pos+x]==1)
                    ansCheck+='1';
                else
                    ansCheck+='0';
            }
            if (!ansCheck.equals(inp))
                sb.append("-1\n");
            else {
                for (int pos = 0; pos < n; pos++) {
                    sb.append(ans[pos]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
