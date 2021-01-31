import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StonesOnTheTable {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            int ans = 0;
            int cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                cnt++;
                if (s.charAt(i) != s.charAt(i+1)){
                    ans += cnt-1;
                    cnt = 0;
                }
            }
            cnt++;
            ans += cnt-1;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
