import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AdvertisingAgency {
    static int MOD = (int) (1e9+7);
    public static long getFact(int n){
        long ans = 1;
        while (n > 0){
            ans *= n;
            ans %= MOD;
            n--;
        }
        return ans;
    }
    public static long pow(long n, int pow){
        if (pow == 0)
            return 1;
        long temp = pow(n, pow/2)%MOD;
        temp *= temp;
        temp %= MOD;
        if (pow % 2 == 1)
            temp *= n;
        temp %= MOD;
        return temp;

    }
    public static long getNcR(int n, int r){
        long ans = 1;
        int temp = n-r;
        while (n > temp){
            ans *= n;
            ans %= MOD;
            n--;
        }
        ans *= pow(getFact(r)%MOD, MOD-2)%MOD;
        ans %= MOD;
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int num = arr[n-k];
            int cntNeeded = 0, freq = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == num) {
                    cntNeeded = i;
                    freq++;
                }
            }
            cntNeeded -= n-k-1;
            long ans = getNcR(freq, cntNeeded)%MOD;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
