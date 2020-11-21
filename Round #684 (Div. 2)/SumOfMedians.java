import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n*k];
            for (int i = 0; i < n * k; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int median = Math.round((float)n/2);
            long sum = 0;
            for (int i = n*k - (n-median+1), j = 0; i >= 0 && j < k ; i-=n-median+1, j++) {
                sum += arr[i];
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
