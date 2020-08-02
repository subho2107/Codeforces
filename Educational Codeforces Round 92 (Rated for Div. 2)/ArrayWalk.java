import java.io.*;
import java.util.*;

public class ArrayWalk {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), z = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            int sum = 0;
            for (int leftMoves = 0; leftMoves < z+1; leftMoves++) {
                int maxPos = k-(2*leftMoves);
                if (maxPos<0)continue;
                int tempSum = 0, maxPair = 0;
                for (int pos = 0; pos <= maxPos; pos++) {
                    if (pos < n-1)
                        maxPair = Math.max(maxPair, arr[pos]+arr[pos+1]);
                    tempSum+=arr[pos];
                }
                sum = Math.max(sum, tempSum+(leftMoves*maxPair));
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
