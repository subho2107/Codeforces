import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JzzhuAndSequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = buffer.readLine().split(" ");
        int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
        int [] arr = new int[8];
        arr[0] = x;arr[1] = y;
        for (int i = 2; i < 8; i++) {
            arr[i] = y-x;
            int diff = y-x;
            x = y;
            y = diff;
        }
        int n = Integer.parseInt(buffer.readLine());
        int MOD = (int) (1e9+7);
        int ans;
        if (n % 6 == 0)
            ans = arr[5];
        else
            ans = arr[(n  % 6)-1];
        if (ans < 0)
            ans = (ans%MOD + MOD) % MOD;
        else
            ans %= MOD;
        System.out.println(ans);
    }
}
