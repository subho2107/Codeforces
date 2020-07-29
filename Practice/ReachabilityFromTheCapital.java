import java.io.*;
import java.util.*;

public class ReachabilityFromTheCapital {
    static List<List<Integer>> edges;
    static boolean[] reachable;
    static boolean[] visited;
    static int cnt = 0;

    static void addEdge(int a, int b) {
        edges.get(--a).add(--b);
    }

    static void markAllReachable(int source) {
        reachable[source] = true;
        for (int neighbour :
                edges.get(source)) {
            if (!reachable[neighbour]) {
                markAllReachable(neighbour);
            }
        }
    }

    static void cntAllReachable(int currNode) {
        visited[currNode] = true;
        cnt++;
        for (int neighbour :
                edges.get(currNode)) {
            if (!visited[currNode] && !reachable[currNode]) {
                cntAllReachable(neighbour);
            }
        }
    }

    static int minimumEdges(int src) {
        markAllReachable(--src);
        ArrayList<int[]> nodesAndCnt = new ArrayList<>();
        for (int vertex = 0; vertex < edges.size(); vertex++) {
            if (!reachable[vertex]) {
                cnt = 0;
                Arrays.fill(visited, false);
                cntAllReachable(vertex);
                nodesAndCnt.add(new int[]{cnt, vertex});
            }
        }
        nodesAndCnt.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] != 0) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        int edgesToBuild = 0;
        for (int pos = 0; pos < nodesAndCnt.size(); pos++) {
            if (!reachable[nodesAndCnt.get(pos)[1]]) {
                ++edgesToBuild;
                markAllReachable(nodesAndCnt.get(pos)[1]);
            }
        }
        return edgesToBuild;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int noOfVertices = Integer.parseInt(inp[0]), noOfEdges = Integer.parseInt(inp[1]), capital = Integer.parseInt(inp[2]);
            edges = new ArrayList<>();
            reachable = new boolean[noOfVertices];
            visited = new boolean[noOfVertices];
            for (int pos = 0; pos < noOfVertices; pos++) {
                edges.add(new ArrayList<>());
            }
            for (int pos = 0; pos < noOfEdges; pos++) {
                inp = buffer.readLine().split(" ");
                int from = Integer.parseInt(inp[0]), to = Integer.parseInt(inp[1]);
                addEdge(from, to);
            }
            sb.append(minimumEdges(capital)).append("\n");
        }
        System.out.println(sb);
    }
}
