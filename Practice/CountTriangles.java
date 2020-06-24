import java.io.*;
import java.util.*;

public class CountTriangles {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]), d = Integer.parseInt(inp[3]);
        long [] prefixSum = new long [b+c+2];
        for (int x = a; x <= b; x++) {
            prefixSum[x+b]++;
            prefixSum[x+c+1]--;
        }

        for (int pos = 1; pos < prefixSum.length; pos++) {
            prefixSum[pos] += prefixSum[pos-1];
        }
        long totalNoTriangles = 0;
        for (int pos = 0; pos < prefixSum.length; pos++) {
            if (prefixSum[pos]==0||pos <= c)continue;
            long cntOfPossZs = Math.min(pos-c, d-c+1);
            totalNoTriangles += cntOfPossZs*prefixSum[pos];
        }
        sb.append(totalNoTriangles+"\n");
        System.out.println(sb);
    }
}
