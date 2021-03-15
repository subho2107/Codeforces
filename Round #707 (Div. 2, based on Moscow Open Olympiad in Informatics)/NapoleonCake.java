import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NapoleonCake {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] creamLayers = new int[n];
            for (int i = 0; i < n; i++) {
                creamLayers[i] = Integer.parseInt(inp[i]);
            }
            long [] suffix = new long[n];
            for (int i = 0; i < n; i++) {
                if (creamLayers[i] == 0)
                    continue;
                suffix[i] += 1;
                int pos = Math.max(0, i - creamLayers[i]);
                if (i-creamLayers[i] >= 0)
                suffix[pos] -= 1;
            }
            for (int i = n-2; i >= 0 ; i--) {
                suffix[i] += suffix[i+1];
            }
            int cnt = 0;
            for (long num : suffix) {
                if (num > 0)
                    sb.append(1+" ");
                else
                    sb.append(0+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
