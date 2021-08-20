import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TitForTat {
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
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j] != 0){
                        arr[j]--;
                        arr[n-1]++;
                        break;
                    }
                }
            }
            for (int num : arr) {
                sb.append(num+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
