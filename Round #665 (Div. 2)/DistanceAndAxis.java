import java.io.*;
import java.util.*;

public class DistanceAndAxis {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            if (k>n)
                sb.append(k-n);
            else
                sb.append((n-k)%2);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
