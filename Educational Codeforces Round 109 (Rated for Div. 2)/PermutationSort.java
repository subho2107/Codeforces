import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PermutationSort {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            boolean check = true;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (arr[i] != i+1)
                    check = false;
            }
            if (check)
                sb.append(0+"\n");
            else {
                if (arr[0] == n && arr[n-1] == 1)
                    sb.append("3\n");
                else if (arr[0] != 1 && arr[n-1] != n)
                sb.append(2+"\n");
                else
                    sb.append(1+"\n");
            }
        }
        System.out.println(sb);
    }
}
