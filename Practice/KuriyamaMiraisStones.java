import java.io.*;
import java.util.*;

public class KuriyamaMiraisStones {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int [] vals = new int[n+1];
            for (int pos = 1; pos <= n; pos++) {
                vals[pos] = Integer.parseInt(inp[pos-1]);
            }
            long [] prefUnSorted = new long[n+1];
            for (int pos = 1; pos <= n; pos++) {
                prefUnSorted[pos] = vals[pos]+prefUnSorted[pos-1];
            }
            Arrays.sort(vals);
            long [] prefSorted = new long[n+1];
            for (int pos = 1; pos <= n; pos++) {
                prefSorted[pos] = vals[pos]+ prefSorted[pos-1];
            }
            int query = Integer.parseInt(buffer.readLine());
            for (int pos = 0; pos < query; pos++) {
                inp = buffer.readLine().split(" ");
                int l = Integer.parseInt(inp[1]), r = Integer.parseInt(inp[2]), type = Integer.parseInt(inp[0]);
                if (type==1)
                    sb.append(prefUnSorted[r]-prefUnSorted[l-1]+"\n");
                else
                    sb.append(prefSorted[r]-prefSorted[l-1]+"\n");
            }

        }
        System.out.println(sb);
    }
}
