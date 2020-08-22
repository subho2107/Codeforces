import java.io.*;
import java.util.*;

public class MereArray {
    public static int gcd(int a, int b){
        if (b==0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int []arr2 = new int[n];

            int minVal = Integer.MAX_VALUE;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                arr2[pos]= arr[pos];

                minVal = Math.min(arr[pos], minVal);
            }
            Arrays.sort(arr2);
            boolean check = true;
            for (int pos = 0; pos < n; pos++) {
                if (arr[pos]!=arr2[pos]){
                    if (arr[pos]%minVal!=0){
                        check = false;
                        break;
                    }
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
