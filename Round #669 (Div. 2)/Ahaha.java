import java.io.*;
import java.util.*;

public class Ahaha {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            int zero = 0, one = 0;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                if (arr[pos] == 0) zero++;
            }
            one = n-zero;
            if (zero>=n/2){
                sb.append(zero+"\n");
                for (int pos = 0; pos < zero; pos++) {
                    sb.append(0+" ");
                }
                sb.append("\n");
            }
            else {
                one-=one%2;
                sb.append(one+"\n");
                for (int i = 0; i < one; i++) {
                    sb.append(1+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
