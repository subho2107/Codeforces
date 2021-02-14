import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewColony {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k= Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int ans = 0;
            while (k > 0){
                ans = -1;
                for (int i = 0; i < n-1; i++) {
                    if (arr[i]<arr[i+1]) {
                        arr[i]++;
                        ans = i+1;
                        break;
                    }
                }
                k--;
                if (ans == -1)
                    break;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
