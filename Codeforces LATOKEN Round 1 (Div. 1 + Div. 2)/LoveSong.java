import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoveSong {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                max = Math.max(arr[i], max);
            }
            long ans = 0;
            for (int i = 0; i < arr.length-1; i++) {
                ans += Math.abs(arr[i]-arr[i+1]);
                if (arr[i] > arr[i+1] && i != arr.length-2)
                    ans -= arr[i] - arr[i+1];
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
