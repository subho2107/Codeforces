import java.io.*;
import java.util.*;

public class Twins {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            float sum = 0, sum2 = 0;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                sum+=arr[pos];
            }
            Arrays.sort(arr);
            sum/=2;
            int pos = n-1;
            for (; pos >=0; pos--) {
                sum2+=arr[pos];
                if (sum2>sum)
                    break;
            }
            sb.append(n-pos).append("\n");
            
        }
        System.out.println(sb);
    }
}
