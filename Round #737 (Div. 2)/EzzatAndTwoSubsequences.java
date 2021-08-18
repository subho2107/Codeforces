import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EzzatAndTwoSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            String [] inp = buffer.readLine().split(" ");
            int max = Integer.MIN_VALUE;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
//                if (Math.abs(max) < Math.abs(arr[i]))
//                    max = arr[i];
                max = Math.max(max, arr[i]);
                sum += arr[i];
            }

            double ans = ( (double)(sum-max))/(n-1)+max;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
