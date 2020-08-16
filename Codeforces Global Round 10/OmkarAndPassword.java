import java.io.*;
import java.util.*;

public class OmkarAndPassword {
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
            boolean check = true;
            for (int pos = 1; pos < n; pos++) {
                if (arr[pos]!=arr[pos-1])
                {
                    check = false;
                    break;
                }
            }
            if (!check)
                sb.append("1\n");
            else
                sb.append(n+"\n");

        }
        System.out.println(sb);
    }
}
