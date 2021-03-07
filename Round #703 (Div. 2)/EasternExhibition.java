import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EasternExhibition {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] x = new int[n],y = new int[n];
            for (int i = 0; i < n; i++) {
                String [] inp = buffer.readLine().split(" ");
                x[i] = Integer.parseInt(inp[0]);
                y[i] = Integer.parseInt(inp[1]);
            }
            Arrays.sort(x);
            Arrays.sort(y);
            long ans = (long) (x[n/2]-x[(n-1)/2] + 1) * (y[n/2] - y[(n-1)/2] + 1);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
