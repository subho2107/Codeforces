import java.io.*;
import java.util.*;

public class SequentialNim {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            if (n == 1) {
                sb.append("First\n");
                continue;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            int pos;
            for (pos = 0; pos < n; pos++) {
                arr.add(Integer.parseInt(inp[pos]));
                if (arr.get(arr.size() - 1) != 1) break;
            }
            if (pos==n)
            {
                if (n%2==0)
                    sb.append("Second\n");
                else
                    sb.append("First\n");
                continue;
            }
            pos++;
            if (pos%2==1)
                sb.append("First\n");
            else
                sb.append("Second\n");

        }
        System.out.println(sb);
    }
}
