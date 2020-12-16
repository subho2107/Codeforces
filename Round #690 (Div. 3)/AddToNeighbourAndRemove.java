import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AddToNeighbourAndRemove {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            long sum = 0;
            int maxNum= 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                maxNum = Math.max(maxNum, arr[i]);
                sum += arr[i];
            }
            ArrayList<Integer>factors = new ArrayList<>();
            for (int fact = 1; (long) fact *fact <= sum; fact++) {
                if (sum % fact == 0 && fact >= maxNum)
                    factors.add(fact);
                if (sum % fact == 0 && sum / fact != fact && (sum/fact)>=maxNum)
                    factors.add((int) (sum/fact));
            }

            int ans = Integer.MAX_VALUE;
            for (int factor : factors) {
                sum = 0;
                int operations = 0;
                boolean check = true;
                for (int i = 0; i < n; i++) {
                    if (sum > 0)
                        operations++;
                    sum += arr[i];
                    if (sum == factor){
                        sum = 0;
                    }
                    else if (sum > factor){
                        check = false;
                        break;
                    }
                }
                if (!check)continue;
                ans = Math.min(ans, operations);
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
