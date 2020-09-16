import java.io.*;
import java.util.*;

public class PermutationForgery {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            for (int pos = n-1; pos >= 0 ; pos--) {
                sb.append(arr[pos]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
