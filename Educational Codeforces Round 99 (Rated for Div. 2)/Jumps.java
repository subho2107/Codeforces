import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Jumps {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int curr = 0, ans = 0;
            for (int i = 1;curr != n ; i++) {
                if (curr < n )
                    curr += i;
                else
                    break;
                ans++;
            }
            if (curr-n==1)
                ans++;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
