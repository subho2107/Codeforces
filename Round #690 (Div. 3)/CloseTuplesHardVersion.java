import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CloseTuplesHardVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] ncr = new int[200001][101];
        int MOD = (int) (1e9 + 7);
        ncr[0][1] = 1;
        for (int i = 1; i < ncr.length; i++) {
            ncr[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 100); j++) {
                ncr[i][j] = (ncr[i - 1][j - 1] + ncr[i - 1][j]) % MOD;
            }
        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            int[] freq = new int[n + 1];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                freq[arr[i]]++;
            }
            for (int minNum = 0; minNum < n + 1; minNum++) {
                if (freq[minNum] == 0)
                    continue;
                ans += ncr[freq[minNum]][m];
                ans %= MOD;
                for (int maxNum = minNum + 1; maxNum <= minNum + k && maxNum <= n; maxNum++) {
                    if (freq[maxNum] == 0)
                        continue;
                    int tempSum = 0;
                    for (int midNum = minNum + 1; midNum < maxNum; midNum++)
                        tempSum += freq[midNum];
                    for (int i = 1; i <= freq[minNum]; i++) {
                        for (int j = 1; j <= freq[maxNum]; j++) {
                            if (i+j > m)
                                break;
                            int rest = m - (i+j);
                            if (rest > tempSum)
                                continue;
                            ans += ((long) ncr[freq[minNum]][i] * ncr[freq[maxNum]][j] * ncr[tempSum][rest] )% MOD;
                            ans %= MOD;
                        }
                    }
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
