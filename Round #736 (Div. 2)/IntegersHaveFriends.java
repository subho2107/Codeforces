import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntegersHaveFriends {
    public static long gcd(long a, long b){
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long [] arr = new long[n], diff = new long[n-1];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inp[i]);
            }
            if (n == 1){
                sb.append(1+"\n");
                continue;
            }
            for (int i = 1; i < n; i++) {
                diff[i-1] = Math.abs(arr[i]-arr[i-1]);
            }
            int ans = 1, temp = 0;
            long currGCD = diff[0];
            for (int i = 0; i < n-1; i++) {
                currGCD = gcd(currGCD, diff[i]);
                if (currGCD == 1){
                    ans = Math.max(ans, temp+1);
                    currGCD = diff[i];
                    temp = 1;
                    if (i == n-2)
                        temp = 0;
                }
                else
                    temp++;
            }
            ans = Math.max(ans, temp+1);
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
