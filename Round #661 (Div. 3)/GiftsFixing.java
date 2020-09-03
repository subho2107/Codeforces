import java.io.*;
import java.util.*;

public class GiftsFixing {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] a = new int[n];
            int [] b = new int[n];
            int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
            for (int pos = 0; pos < n; pos++) {
                a[pos] = Integer.parseInt(inp[pos]);
                minA = Math.min(a[pos], minA);

            }
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < n; pos++) {
                b[pos] = Integer.parseInt(inp[pos]);
                minB = Math.min(b[pos], minB);
            }
            long sum = 0;
            for (int pos = 0; pos < n; pos++) {
                sum+=Math.max(a[pos]-minA,b[pos]-minB);
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
