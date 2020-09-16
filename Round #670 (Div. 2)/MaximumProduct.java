import java.io.*;
import java.util.*;

public class MaximumProduct {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            long[] arr = new long[n];
            int posCnt = 0, negCnt = 0;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                if (arr[pos] > 0) posCnt++;
                else negCnt++;
            }
            long pro;
            long ans = 1;
            if (n == 5) {
                for (int pos = 0; pos < n; pos++) {
                    ans *= arr[pos];
                }
                sb.append(ans).append("\n");
                continue;
            }
            Arrays.sort(arr);
            for (int i = arr.length - 1; i >= arr.length - 5; i--) {
                ans *= arr[i];
            }
            pro = ans;
            int cnt = 0, left = 0, right = n - 1;
            if (negCnt >= 2 && posCnt >= 3){
                ans = arr[0]*arr[1]*arr[n-1]*arr[n-2]*arr[n-3];
                pro = Math.max(pro, ans);
            }
            if (negCnt >= 4 && posCnt >= 1){
                ans = arr[n-1]*arr[0]*arr[1]*arr[2]*arr[3];
                pro = Math.max(pro, ans);
            }
            sb.append(pro).append("\n");
        }
        System.out.println(sb);
    }
}