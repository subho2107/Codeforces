import java.io.*;
import java.util.*;

public class PeacefulRooks {
    public static boolean dfs(int vertex, boolean[]visited, boolean[] recStack, ArrayList<Integer>[]graph){
        if (!visited[vertex]){
            visited[vertex] = true;
            recStack[vertex] = true;
            for (int neighbour : graph[vertex]) {
                if (!visited[neighbour] && dfs(neighbour, visited, recStack, graph))
                    return true;
                else if (recStack[neighbour])
                    return true;
            }
        }
        recStack[vertex] = false;
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int moves = 0;
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                inp = buffer.readLine().split(" ");
                int u = Integer.parseInt(inp[0])-1, v = Integer.parseInt(inp[1])-1;
                if (u != v) {
                    moves++;
                    graph[u].add(v);
                }
            }
            boolean[]visited = new boolean[n], recStack = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dfs(i, visited,recStack, graph))
                    moves++;
            }
            sb.append(moves+"\n");
        }
        System.out.println(sb);
    }
}
