import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpyDetected {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (arr[i] != 2)
                    cnt++;
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }
}
