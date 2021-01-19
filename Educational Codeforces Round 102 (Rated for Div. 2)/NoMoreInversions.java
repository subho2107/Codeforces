import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NoMoreInversions {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            for (int i = 1; i < k-(n-k); i++) {
                sb.append(i+" ");
            }
            for (int i = k; i >= k-(n-k); i--) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
