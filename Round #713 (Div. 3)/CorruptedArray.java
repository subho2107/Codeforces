import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CorruptedArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            Integer [] arr = new Integer[n+2];
            for (int i = 0; i < n + 2; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            long sum = 0;
            for (int i = 0; i < n + 1; i++) {
                sum += arr[i];
            }
            boolean check = false;
            for (int i = 0; i < n + 1; i++) {
                if (sum - arr[i] == arr[n+1]){
                    check = true;
                    for (int j = 0; j < n + 1; j++) {
                        if (j == i)continue;
                        sb.append(arr[j]+" ");
                    }
                    sb.append("\n");
                    break;
                }
            }
            if (check)
                continue;
            if (sum - arr[n] == arr[n]){
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]+" ");
                }
                sb.append("\n");
            }
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}