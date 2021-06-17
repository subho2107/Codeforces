import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InterestingFunction {
    public static long getChanges(int n){
        long ans = 0;
        int tens = 1;
        while (tens <= n){
            ans += n / tens;
            tens*= 10;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int l = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
//
            long ans = getChanges(r)-getChanges(l);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
