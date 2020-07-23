import java.io.*;
import java.util.*;
class Graph{
    List<List<Integer>>edges;
    boolean [] reachable;
    boolean [] visited;
    Graph(int n){
        edges = new ArrayList<>();
        reachable = new boolean[n];
        visited = new boolean[n];
        for (int pos = 0; pos < n; pos++) {
            edges.add(new ArrayList<>());
        }
    }
    void addEdge(int a, int b){
        edges.get(--a).add(--b);
    }
    void markAllReachableFromSrc(int source){
        this.reachable[--source] = true;
        for (int neighbour :
                edges.get(source)) {
            if (!reachable[neighbour]) {
                markAllReachableFromSrc(neighbour);
            }
        }
    }
    void markAllReachable(int currNode){

    }

}
public class ReachabilityFromTheCapital {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int noOfVertices = Integer.parseInt(inp[0]), noOfEdges = Integer.parseInt(inp[1]), capital = Integer.parseInt(inp[2]);
            Graph graph = new Graph(noOfVertices);
            for (int pos = 0; pos < noOfEdges; pos++) {
                inp = buffer.readLine().split(" ");
                int from = Integer.parseInt(inp[0]), to = Integer.parseInt(inp[1]);
                graph.addEdge(from, to);
            }

        }
        System.out.println(sb);
    }
}
