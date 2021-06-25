import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChallengingCliffs {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            Integer [] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int pos = -1, minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i+1] - arr[i] < minDiff){
                    minDiff = arr[i+1] - arr[i];
                    pos = i;
                }
            }
            for (int i = pos; i < n; i++) {
                if (i == pos+1)
                    continue;
                sb.append(arr[i]+" ");
            }
            for (int i = 0; i < pos; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append(arr[pos+1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
