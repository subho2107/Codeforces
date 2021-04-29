import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ExplorerSpace {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
        if (k % 2 == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(-1 + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        int[][] index = new int[n][m];
        int num = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                index[i][j] = num++;
        int size = n * m;
        ArrayList<int[]>[] adj = new ArrayList[size];//0 is vertex 1 is weight
        for (int i = 0; i < size; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inp = buffer.readLine().split(" ");
            for (int j = 0; j < m - 1; j++) {
                int u = index[i][j], v = index[i][j + 1], w = Integer.parseInt(inp[j]);
                adj[u].add(new int[]{v, w});
                adj[v].add(new int[]{u, w});
            }
        }
        for (int i = 0; i < n - 1; i++) {
            inp = buffer.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int u = index[i][j], v = index[i + 1][j], w = Integer.parseInt(inp[j]);
                adj[u].add(new int[]{v, w});
                adj[v].add(new int[]{u, w});
            }
        }
        k/=2;
        int [][] dp = new int[size][k];
        for (int i = 0; i < size; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            for (int[] edge : adj[i]) {
                dp[i][0] = Math.min(dp[i][0], edge[1]*2);
            }
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < size; j++) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int[] edge : adj[j]) {
                    dp[j][i] = Math.min(dp[j][i], dp[edge[0]][i-1]+2*edge[1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dp[index[i][j]][k-1]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
