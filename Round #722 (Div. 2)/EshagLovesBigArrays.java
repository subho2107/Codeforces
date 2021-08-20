import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EshagLovesBigArrays {
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
            Arrays.sort(arr);
            int num = arr[0];
            int cnt = 0;
            for (int i : arr) {
                if (i != num)
                    cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
