import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoenixAndTowers {
    public static boolean isOk(long [] arr, int x){
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (long num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min <= x;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), x = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            int [][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(inp[i]);
                arr[i][1] = i;
            }
            Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
            int [] ans = new int[n];
            long [] buildings = new long[m];
            int start = 0;
            int direction = 0;
            while (start < n){
                if (direction == 0){
                    for (int i = 0;start+i < n && i < m; i++) {
                        buildings[i] += arr[start+i][0];
                        ans[arr[start+i][1]] = i+1;
                    }
                }
                else {
                    for (int i = m-1; i >= 0; i--) {
                        if (start+i >= n)
                            continue;
                        buildings[i] += arr[start+i][0];
                        ans[arr[start+i][1]] = i+1;
                    }
                }
                direction ^= 1;
                start += m;
            }
            if (isOk(buildings, x)){
                sb.append("YES\n");
                for (int num : ans) {
                    sb.append(num+" ");
                }
                sb.append("\n");
                continue;
            }
            Arrays.fill(buildings, 0);
            start = 0;
            while (start < n){
                for (int i = 0;start+i < n && i < m; i++) {
                    buildings[i] += arr[start+i][0];
                    ans[arr[start+i][1]] = i+1;
                }
                start += m;
            }
            if (isOk(buildings, x)){
                sb.append("YES\n");
                for (int num : ans) {
                    sb.append(num+" ");
                }
                sb.append("\n");
            }
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
