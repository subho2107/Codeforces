import java.io.*;
import java.util.*;

public class LuntikAndSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n =Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");

            int zero = 0, one = 0;
            long ans = 1;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                if (num == 0) {
                    ans *= 2;
                }
                else if (num == 1) {
                    one++;
                }
            }
            ans *= one;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
