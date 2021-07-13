import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AquaMoonAndTwoArrays {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inp[i]);
            }
            int [] b = new int[n];
            inp = buffer.readLine().split(" ");
            long sum = 0, diff = 0;
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(inp[i]);
                sum += b[i] - a[i];
                diff += Math.max(b[i] - a[i], 0);
            }
            if (sum != 0){
                sb.append("-1\n");
                continue;
            }
            sb.append(diff+"\n");
            while (diff-- > 0){
                int less = -1, high = -1;
                for (int i = 0; i < n; i++) {
                    if (a[i] > b[i] && less == -1)
                        less = i;
                    if (a[i] < b[i] && high == -1)
                        high = i;
                }
                a[less]--;a[high]++;
                sb.append((less+1)+" "+(high+1)+"\n");
            }
        }
        System.out.println(sb);
    }
}
