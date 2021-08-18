import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cobb {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int [] arr = new int[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            long ans = Long.MIN_VALUE;
            for (int i = Math.max(n-2*k-1, 0); i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    ans = Math.max(ans, (long) (i+1)*(j+1) - (long) k *(arr[i]|arr[j]));
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
