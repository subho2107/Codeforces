import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class AvoidingZero {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            Integer [] arr = new Integer[n];int sum = 0;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                sum += arr[pos];
            }
            if (sum == 0){
                sb.append("NO\n");
            }
            else if (sum > 0){
                sb.append("YES\n");
                Arrays.sort(arr, Collections.reverseOrder());
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]+" ");
                }
                sb.append("\n");
            }
            else {
                sb.append("YES\n");
                Arrays.sort(arr);
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]+" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
