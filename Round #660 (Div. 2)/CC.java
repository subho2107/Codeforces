import java.io.*;
import java.util.*;

public class CC {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            System.out.println("case");
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            long [] pop = new long[n];
            for (int pos = 0; pos < n; pos++) {
                pop[pos] = Integer.parseInt(inp[pos]);
            }
            int [] happ = new int[n];
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < n; pos++) {
                happ[pos] = Integer.parseInt(inp[pos]);
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                ArrayList<Integer>temp = new ArrayList<>();
                graph.add(temp);
            }
            for (int pos = 0; pos < n - 1; pos++) {
                inp = buffer.readLine().split(" ");
                int from = Integer.parseInt(inp[0]), to = Integer.parseInt(inp[1]);
                graph.get(from-1).add(to-1);
            }
            int [] parent = new int[n], distance = new int[n];
            Arrays.fill(distance, -1);
            distance[0] = 0;
            Queue<Integer>queue = new ArrayDeque<>();
            queue.add(0);
            while(queue.size()>0){
                int currVertex = queue.poll();
                for(int nbr: graph.get(currVertex)){
                    if (distance[nbr]==-1){
                        distance[nbr] = distance[currVertex]+1;
                        parent[nbr] = currVertex;
                        queue.add(nbr);
                    }
                }
            }
            pop[0] = m- pop[0];
            for (int pos = 1; pos < n; pos++) {
                int currVertPar = parent[pos];
                while(currVertPar!=0){
                    pop[currVertPar]+=pop[pos];
                    currVertPar = parent[currVertPar];
                }
            }
            System.out.println(Arrays.toString(pop));
            boolean check = true;
            for (int pos = 0; pos < n; pos++) {
                if (pos==0){
                    if (happ[pos]<-m||happ[pos]>m){
                        check = false;
                        break;
                    }
                }
                else if (happ[pos]<-pop[pos]||happ[pos]>pop[pos]){
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
