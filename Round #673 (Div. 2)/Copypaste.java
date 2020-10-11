import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copypaste {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]),k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            Arrays.sort(arr);
            long ans = 0;
            for (int pos = 1; pos < n; pos++) {
                ans+=(k-arr[pos])/arr[0];
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
