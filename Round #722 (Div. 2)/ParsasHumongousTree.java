import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class ParsasHumongousTree {
    static long ans;
    static int [][]lr;
    static ArrayList<Integer>[]adj;
    static long [] vals;
    public static void dfs(int vertex, int parent){
        if (parent == -1){
            int voteL = 0, voteR = 0;
            int l = lr[vertex][0], r = lr[vertex][1];
            for (int neighbour : adj[vertex]) {
                int [] vals = lr[neighbour];
                int [] arr = {Math.abs(l - vals[0]), Math.abs(l - vals[1]), Math.abs(r - vals[0]), Math.abs(r - vals[1])};
                if (Math.max(arr[0], arr[1]) > arr[2] && Math.max(arr[0], arr[1]) > arr[3])
                    voteL++;
                else voteR++;
            }
            Stack<Integer>stack = new Stack<>();

            vals[vertex] = r;
            if (voteL > voteR)
                vals[vertex] = l;
        }
        for (int neighbour : adj[vertex]) {
            if (neighbour == parent)
                continue;
            int l = lr[neighbour][0], r = lr[neighbour][1];
            long a = Math.abs(vals[vertex] - l), b = Math.abs(vals[vertex] - r);
            vals[neighbour] = l;
            if (b > a)
                vals[neighbour] = r;
            ans += Math.abs(vals[vertex] - vals[neighbour]);
            dfs(neighbour, vertex);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            lr = new int[n][2];
            ans = 0;
            for (int i = 0; i < n; i++) {
                String [] inp = buffer.readLine().split(" ");
                lr[i][0] = Integer.parseInt(inp[0]);
                lr[i][1] = Integer.parseInt(inp[1]);
            }
            vals = new long[n];
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                String [] inp = buffer.readLine().split(" ");
                int u = Integer.parseInt(inp[0])-1, v = Integer.parseInt(inp[1])-1;
                adj[u].add(v);
                adj[v].add(u);
            }
            int start = -1, maxChild = 0;
            for (int i = 0; i < n; i++) {
                if (adj[i].size() > maxChild){
                    maxChild = adj[i].size();
                    start = i;
                }
            }
            dfs(start, -1);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
