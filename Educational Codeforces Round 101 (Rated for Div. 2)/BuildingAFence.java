import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildingAFence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(inp[i]);
            }
            int[][] range = new int[n][2];
            range[0][0] = heights[0];
            range[0][1] = heights[0];
            boolean check = true;
            for (int i = 1; i < n - 1; i++) {
                range[i][0] = Math.max(heights[i], range[i - 1][0] - (k - 1));
                range[i][1] = Math.min(heights[i] + k - 1, range[i - 1][1] + k - 1);
                if (range[i][0] > range[i][1] || !(range[i][0] >= heights[i] && range[i][1] <= heights[i] + k - 1)) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                sb.append("NO\n");
                continue;
            }
            range[n - 1][0] = heights[n - 1];
            range[n - 1][1] = heights[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                range[i][0] = Math.max(range[i][0], range[i + 1][0] - (k - 1));
                range[i][1] = Math.min(range[i][1], range[i + 1][1] + k - 1);
                if (range[i][0] > range[i][1] || !(range[i][0] >= heights[i] && range[i][1] <= heights[i] + k - 1)) {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");

        }
        System.out.println(sb);
    }
}
