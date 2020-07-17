import java.io.*;
import java.util.*;

public class MahmoudAndATriangle {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] arr = new int[n];
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
        }
        Arrays.sort(arr);
        boolean check = false;
        for (int pos = 0; pos <= n-3; pos++) {
            if (arr[pos]+arr[pos+1]> arr[pos+2])
            {
                check = true;
                break;
            }
        }
        if (check)
            sb.append("YES");
        else
            sb.append("NO");
        sb.append("\n");
        System.out.println(sb);
    }
}
