import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PleasantPairs {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp =buffer.readLine().split(" ");
            int [] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(inp[i-1]);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                int start = (2*i - 1)/arr[i];
                for (int j = start*arr[i]; j>= i+1; j-=arr[i]) {
                    int pos = j-i, num = j/arr[i];
                    if (arr[pos] == num)
                        cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
