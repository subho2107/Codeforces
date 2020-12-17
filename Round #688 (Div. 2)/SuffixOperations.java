import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SuffixOperations {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inp[i]);
            long minOperations = 0;
            for (int i = 0; i < n - 1; i++)
                minOperations += Math.abs(arr[i]-arr[i+1]);
            int maxDiff = Math.max(Math.abs(arr[0]-arr[1]), Math.abs(arr[n-1]-arr[n-2]));
            for (int i = 1; i < n - 1; i++) {
                maxDiff = Math.max(maxDiff, Math.abs(arr[i]-arr[i-1])+Math.abs(arr[i+1]-arr[i])-Math.abs(arr[i-1]-arr[i+1]));
            }
            minOperations -= maxDiff;
            sb.append(minOperations+"\n");
        }
        System.out.println(sb);
    }
}
