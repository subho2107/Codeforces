import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShiftingStacks {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long [] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            for (int i = 0; i < n-1; i++) {
                if (arr[i] > i){
                    long diff = arr[i] - i;
                    arr[i] = i;
                    arr[i+1] += diff;
                }
            }
            boolean check = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] >= arr[i+1])
                {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
