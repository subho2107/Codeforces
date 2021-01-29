import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Inflation {
    public static boolean isAns(int [] arr, int k, long prevSum){
        prevSum += arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i]* 100L > prevSum*k)
                return false;
            prevSum += arr[i];
        }
        return true;
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
            long low = 0, high = (long) 1e17, ans = 0;
            while (low <= high){
                long mid = (high+low)>>1;
                if (isAns(arr, k, mid))
                {
                    ans = mid;
                    high = mid-1;
                }
                else
                    low = mid+1;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
