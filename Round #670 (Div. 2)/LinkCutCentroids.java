import java.io.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class LinkCutCentroids {
    static ArrayList<ArrayList<Integer>>graph;
    static int [] subtreeSizes;
    static int [] maxConnGrp;
    public static void dfs(int vertex, int parent){
        subtreeSizes[vertex] = 1;
        for (Integer nbr : graph.get(vertex)) {
            if (nbr == parent)continue;
            dfs(nbr, vertex);
            subtreeSizes[vertex]+=subtreeSizes[nbr];
            maxConnGrp[vertex] = Math.max(maxConnGrp[vertex], subtreeSizes[nbr]);
        }
        maxConnGrp[vertex] = Math.max(maxConnGrp[vertex], graph.size()-subtreeSizes[vertex]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            graph = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                graph.add(new ArrayList<>());
            }
            for (int pos = 0; pos < n - 1; pos++) {
                String [] inp = buffer.readLine().split(" ");
                int x = Integer.parseInt(inp[0])-1, y = Integer.parseInt(inp[1])-1;
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            subtreeSizes = new int[n];
            maxConnGrp = new int[n];
            dfs(0, -1);
            int minVal = Integer.MAX_VALUE, cnt = 0;
            int vertex1 = -1, vertex2 = -1;
            for (int pos = 0; pos < n; pos++) {
                if (maxConnGrp[pos] == minVal)
                    cnt++;
                if (maxConnGrp[pos] < minVal){
                    minVal = maxConnGrp[pos];
                    cnt = 1;
                }
            }
            if (maxConnGrp.length == 1 || cnt == 1){
                int x = 0, y = 0;
                for (int pos = 0; pos < n; pos++) {
                    if (graph.get(pos).size()>=1){
                        x = pos;
                        y = graph.get(pos).get(0);
                        break;
                    }
                }
                x++;y++;
                sb.append(x).append(" ").append(y).append("\n");
                sb.append(x).append(" ").append(y).append("\n");
                continue;
            }
            for (int pos = 0; pos < n; pos++) {
                if (maxConnGrp[pos] == minVal){
                    if (vertex1 == -1){
                        vertex1 = pos;
                    }
                    else {
                        vertex2 = pos;
                        break;
                    }
                }
            }
            int x = 0;
            for (Integer nbr : graph.get(vertex1)) {
                x = nbr;
                if (nbr != vertex2)
                    break;
            }
            vertex1++;vertex2++;x++;
            sb.append(vertex1+" "+x).append("\n");
            sb.append(vertex2+" "+x).append("\n");
        }
        System.out.println(sb);
    }
}
