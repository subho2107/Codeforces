import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AGAGAXOOORRR {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp =buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int xor = 0;
            for (int i = 0; i < n; i++) {
                xor ^= arr[i];
            }
            if (xor == 0)
                sb.append("YES\n");
            else {
                int tempXor = 0;
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (cnt == 2)
                        break;
                    tempXor ^= arr[i];
                    if (tempXor == xor) {
                        tempXor = 0;
                        cnt++;
                    }
                }

                if (cnt >= 2)
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
