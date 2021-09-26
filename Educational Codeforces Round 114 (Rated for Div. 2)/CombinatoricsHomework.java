import java.io.*;
import java.util.*;

public class CombinatoricsHomework {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int a = arr[0], b = arr[1];
            int c = arr[2], m = Integer.parseInt(inp[3]);
            if (m >= c-1-a-b && m <= a+b+c-3)
                sb.append("Yes\n");
            else
                sb.append("No\n");
            
        }
        System.out.println(sb);
    }
}
