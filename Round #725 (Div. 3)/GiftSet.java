import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GiftSet {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]), a = Integer.parseInt(inp[2]), b = Integer.parseInt(inp[3]);
            if (a == b){
                long ans = Math.min(x/a, y/b);
                sb.append(ans).append("\n");
                continue;
            }
            if (a < b)
                a = a^b^(b = a);
            long low = 0, high = (int) (1e9+100);
            while (high-low > 1){
                long mid = (low+high)/2;
                long max = (long) Math.floor(((x - mid*b)*1.0)/(a - b));
                long min = (long) Math.ceil(((y - mid*a)*1.0)/(b - a));
                if (Math.max(min, 0) <= Math.min(max, mid))
                    low = mid;
                else
                    high = mid;
            }
            sb.append(low+"\n");
        }
        System.out.println(sb);
    }
}
