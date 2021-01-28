import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BallInBerland {
    public static long getNc2(int n){
        long ans = (long) n*(n-1)/2;
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            HashMap<Integer, Integer>boys = new HashMap<>();
            for (int i = 0; i < k; i++) {
                int num = Integer.parseInt(inp[i]);
                boys.put(num, boys.getOrDefault(num, 0)+1);
            }
            HashMap<Integer, Integer>girls = new HashMap<>();
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                int num = Integer.parseInt(inp[i]);
                girls.put(num, girls.getOrDefault(num, 0)+1);
            }
            long ans = getNc2(k);
            long sum = 0;
            for (int num : boys.values()) {
                sum += getNc2(num);
            }
            for (int num : girls.values()) {
                sum += getNc2(num);
            }
            ans -= sum;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
