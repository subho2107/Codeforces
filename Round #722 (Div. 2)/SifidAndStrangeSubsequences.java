import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SifidAndStrangeSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp =buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            if (arr[n-1] - arr[0] < arr[n-1])
                sb.append("1\n");
            else {
                int cnt = 1;
                for (int i = 0; i < n;) {
                    int temp = arr[i];
                    i++;
                    while (i < n && arr[i] - temp < arr[n-1])
                        i++;
                    if (i <= n-1)
                        cnt++;
                }
                int ans = cnt;
                cnt = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 1; i < n; i++) {
                    int diff = arr[i] - arr[i-1];
                    min = Math.min(min, diff);
                    if (min >= arr[i])
                        cnt = Math.max(cnt, i+1);
                }
                ans = Math.max(ans, cnt);
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
}
