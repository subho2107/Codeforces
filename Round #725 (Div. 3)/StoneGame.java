import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoneGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minPos = 0, maxPos = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (arr[i] > max) {
                    max = arr[i];
                    maxPos = i;
                }
                if (arr[i] < min) {
                    min = arr[i];
                    minPos = i;
                }
            }
            int ans = Math.max(minPos, maxPos)+1;
            ans = Math.min(ans, n-Math.min(minPos, maxPos));
            ans = Math.min(ans, Math.min(minPos, maxPos)+1+n-Math.max(minPos, maxPos) );
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
