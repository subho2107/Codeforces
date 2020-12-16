import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FavoriteSequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int start = 0, end = n-1;
            for (int i = 0; start <= end; i++, start++, end--) {
                sb.append(arr[start]+" ");
                if (start != end)
                    sb.append(arr[end]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
