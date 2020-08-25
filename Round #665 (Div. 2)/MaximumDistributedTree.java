import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class MaximumDistributedTree {
    static int [] subtreeSize;
    static List<List<Integer>>graph;
    static List<Long>edgeWeights;
    static int n;
    public static void dfs(int vertex, int parent){
        subtreeSize[vertex] = 1;
        for (int nbr:graph.get(vertex)){
            if (parent==nbr)continue;
            dfs(nbr, vertex);
            subtreeSize[vertex] += subtreeSize[nbr];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(buffer.readLine());
            graph = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                graph.add(new ArrayList<>());
            }
            for (int pos = 0; pos < n - 1; pos++) {
                String [] inp = buffer.readLine().split(" ");
                int  u = Integer.parseInt(inp[0]), v = Integer.parseInt(inp[1]);
                u--;v--;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int m = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] primes = new int[m];
            for (int pos = 0; pos < m; pos++) {
                primes[pos] = Integer.parseInt(inp[pos]);
            }
            long[] values = new long[n-1];
            Arrays.fill(values, 1);
            Arrays.sort(primes);
            int primesPos = 0;
            for (int pos = Math.max(0, n-1-m); pos < n-1; pos++, primesPos++) {
                values[pos] = primes[primesPos];
            }
            int  mod = (int) (1e9+7);
            for (; primesPos<m; primesPos++)
                values[n-2]=values[n-2]*primes[primesPos]%mod;
            edgeWeights = new ArrayList<>();
            subtreeSize = new int[n];
            dfs(0, -1);
            for (int pos = 1; pos < n; pos++) {
                long temp = subtreeSize[pos]*(long)(n-subtreeSize[pos]);
                edgeWeights.add(temp);
            }
            Collections.sort(edgeWeights);
            Arrays.sort(values);
            System.out.println(edgeWeights.toString());
            System.out.println(Arrays.toString(values));
            long ans = 0;
            for (int pos = 0; pos < n-1; pos++) {
               long temp = (edgeWeights.get(pos)%mod* values[pos]%mod)%mod;
               ans = (ans%mod+temp%mod)%mod;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
