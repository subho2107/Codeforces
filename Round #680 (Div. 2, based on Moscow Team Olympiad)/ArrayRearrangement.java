import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayRearrangement {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            int [] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(b);
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (a[i] + b[n-i-1] > x)
                {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("Yes");
            else
                sb.append("No");
            sb.append("\n");
            if (t != 0)
            inp = buffer.readLine().split(" ");
        }
        System.out.println(sb);
    }
}
