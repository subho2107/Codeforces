import java.io.*;
import java.util.*;

public class OmkarAndWaterslide {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String []  inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            long cnt = 0;
            for (int pos = 1; pos < n; pos++) {
                cnt += Math.max(arr[pos-1]-arr[pos], 0);
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
