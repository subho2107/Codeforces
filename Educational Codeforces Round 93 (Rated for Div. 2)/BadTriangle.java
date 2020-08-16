import java.io.*;
import java.util.*;

public class BadTriangle {
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
            int sum = arr[0]+arr[1];
            boolean check = false;
            int ansPos = 0;
            for (int pos = 2; pos < n; pos++) {
                if (arr[pos]>=sum){
                    check = true;
                    ansPos = pos;
                    break;
                }
            }
            ansPos++;
            if (check){
                sb.append("1 2 "+ansPos+"\n");
            }
            else{
                sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}
