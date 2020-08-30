import java.io.*;
import java.util.*;

public class PowerSequence {
    static int mod = (int) (1e9+7);
    public static long pow(long num, long power) {
        if (power == 0) return 1;
        long res = pow(num, power / 2) % mod;
        res = (res%mod*res%mod)%mod;
        if (power % 2 == 0)
            return res % mod;
        else
            return (res%mod * num%mod) % mod;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split( " ");
        int []arr = new int[n];
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
        }
        Arrays.sort(arr);
        long ans = (long) 1e20;
        for (long c = 0;; c++) {
            long changes = 0;
            long powNum = 1;
            for (int pos = 0; pos < n; pos++, powNum*=c) {
                if (powNum<0||powNum>=1e10||changes<0){
                    changes = -1;
                    break;
                }
                changes+=Math.abs(arr[pos]-powNum);
            }
            if (changes==-1)
                break;
            ans = Math.min(ans, changes);
        }
        System.out.println(ans);
    }
}
