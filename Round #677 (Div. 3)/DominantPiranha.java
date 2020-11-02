import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DominantPiranha {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            boolean check = true;
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (i >= 1 && arr[i] != arr[i-1])
                    check = false;
                maxVal = Math.max(maxVal, arr[i]);
            }
            if (check)
                sb.append(-1+"\n");
            else {
                int i = 0;
                for (; i < n; i++){
                    if ( arr[i] == maxVal && ((i!=n-1 && arr[i+1] != maxVal) || (i!=0 && arr[i-1]!=maxVal)))
                        break;
                }
                sb.append((i+1) + "\n");
            }

        }
        System.out.println(sb);
    }
}
