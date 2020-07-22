import java.io.*;
import java.util.*;

public class PrefixFlipEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] inp = buffer.readLine().toCharArray();
            int [] a = new int[n];
            int [] b = new int [n];
            for (int pos = 0; pos < n; pos++) {
                a[pos] = Character.getNumericValue(inp[pos]);
            }
            inp = buffer.readLine().toCharArray();
            for (int pos = 0; pos < n; pos++) {
                b[pos] = Character.getNumericValue(inp[pos]);
            }
            int cnt = 0;
            StringBuilder steps = new StringBuilder();
            for (int pos = 0; pos < n; pos++) {
                if (a[pos]!=b[pos]) {
                    steps.append(pos+1+" ");
                    steps.append(1+" ");
                    steps.append(pos+1+" ");
                    cnt++;
                }
            }
            sb.append(3*cnt+" "+steps+"\n");
 }
        System.out.println(sb);
    }
}
