import java.io.*;
import java.util.*;

public class GameWithArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), sum = Integer.parseInt(inp[1]);
        if (sum >= 2*n)
        {
            sb.append("YES\n");
            for (int pos = 0; pos < n - 1; pos++) {
                sb.append("2 ");
                sum-=2;
            }
            sb.append(sum+"\n");
            sb.append("1\n");
        }
        else
        {
            sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
