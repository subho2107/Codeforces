import java.io.*;
import java.util.*;

public class OmkarAndInfinityClock {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            long k = Long.parseLong(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int maxVal = Integer.MIN_VALUE;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                maxVal = Math.max(maxVal, arr[pos]);
            }
            int [] arr2 = new int[n];
            int maxVal2 = Integer.MIN_VALUE;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = maxVal - arr[pos];
                maxVal2 = Math.max(maxVal2, arr[pos]);
            }
            for (int pos = 0; pos < n; pos++) {
                arr2[pos] = maxVal2-arr[pos];
            }
            if (k%2==0){
                for (int pos = 0; pos < n; pos++) {
                    sb.append(arr2[pos]+" ");
                }
                sb.append("\n");
            }
            else {
                for (int pos = 0; pos < n; pos++) {
                    sb.append(arr[pos]+" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
