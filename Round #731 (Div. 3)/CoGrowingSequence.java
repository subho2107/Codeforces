import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoGrowingSequence {
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
            int [] ans = new int[n];
            for (int i = 1; i < n; i++) {
                int temp = ans[i-1]|arr[i-1];
                int curr = 0;
                for (int j = 0; j < 30; j++) {
                    int val = 1<<j;
                    if ((temp & val) != 0 && (arr[i] & val) == 0){
                        curr |= val;
                    }
                }
                ans[i] = curr;
            }
            for (int i : ans) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
