import java.io.*;
import java.util.*;

public class StringTransformation1 {
    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        inner:while (t-- > 0) {
            int n = Integer.parseInt(bu.readLine());
            char[]a = bu.readLine().toCharArray();
            char [] b = bu.readLine().toCharArray();
            for (int pos = 0; pos < n; pos++) {
                if (a[pos] > b[pos]) {
                    sb.append("-1\n");
                    continue inner;
                }

            }
            int operations = 0;
            for (char ch = 'a'; ch < 'z'+1; ch++) {
                char minChar='z'+1;
                boolean check = false;
                for (int pos = 0; pos < n; pos++) {
                    if (a[pos]!=b[pos] && a[pos]==ch) {
                        minChar = (char) Math.min(minChar, b[pos]);
                        check = true;
                    }
                }
                for (int pos = 0; pos < n; pos++) {
                    if (a[pos]!=b[pos] && a[pos]==ch)
                        a[pos] = minChar;
                }
                if (check)
                    operations++;
            }
            sb.append(operations+"\n");
        }
        System.out.print(sb);
    }
}
