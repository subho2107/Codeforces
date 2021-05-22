import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AndThenThereWereK {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int len = Integer.toBinaryString(n).length();
            int ans = 0;
            for (int i = 0; i < len-1; i++) {
                ans += Math.pow(2, i);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
