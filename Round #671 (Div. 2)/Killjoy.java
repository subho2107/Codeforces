import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Killjoy {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int affected = 0, diff = 0;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                diff += x-arr[pos];
                if (arr[pos] == x)
                    affected++;
            }
            if (affected == n)
                sb.append("0\n");
            else if (affected >= 1 || diff == 0)
                sb.append("1\n");
            else
                sb.append("2\n");
        }
        System.out.println(sb);
    }
}
