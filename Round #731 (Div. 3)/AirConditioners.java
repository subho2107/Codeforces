import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AirConditioners {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String tem = buffer.readLine();
            if (tem.length() == 0) {
                t++;
                continue;
            }
            String [] inp = tem.split(" ");
            int n = Integer.parseInt(inp[0]), k =Integer.parseInt(inp[1]);
            Integer [][] posTemp = new Integer[k][2];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                posTemp[i][0] = Integer.parseInt(inp[i])-1;
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                posTemp[i][1] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(posTemp, (o1, o2) -> o1[0] - o2[0]);
            int [] arr = new int[n];
            Arrays.fill(arr, Integer.MAX_VALUE);
            for (int i = 0; i < k; i++) {
                arr[posTemp[i][0]] = posTemp[i][1];
            }
            int [] ans = new int[n], ans2 = new int[n];
            Arrays.fill(ans, Integer.MAX_VALUE);
            Arrays.fill(ans2, Integer.MAX_VALUE);
            int currTemp = posTemp[0][1];
            for (int i = posTemp[0][0]; i < n; i++) {
                currTemp = Math.min(currTemp, arr[i]);
                ans[i] = currTemp;
                currTemp++;
            }
            currTemp = posTemp[k-1][1];
            for (int i = posTemp[k-1][0]; i >= 0; i--) {
                currTemp = Math.min(currTemp, arr[i]);
                ans2[i] = currTemp;
                currTemp++;
            }
            for (int i = 0; i < n; i++) {
                ans[i] = Math.min(ans[i], ans2[i]);
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
