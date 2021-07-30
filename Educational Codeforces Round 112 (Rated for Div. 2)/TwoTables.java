import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoTables {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int W = Integer.parseInt(inp[0]), H = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int x1 = Integer.parseInt(inp[0]), y1 = Integer.parseInt(inp[1]), x2 = Integer.parseInt(inp[2]), y2 = Integer.parseInt(inp[3]);
            inp = buffer.readLine().split(" ");
            int w = Integer.parseInt(inp[0]), h = Integer.parseInt(inp[1]);
            int minDist = Integer.MAX_VALUE;
            if (x2-x1+w <= W)
                minDist = Math.min(minDist, Math.min(Math.max(x2-(W-w), 0), Math.max(w-x1, 0)));
            if (y2-y1+h <= H)
                minDist = Math.min(minDist, Math.min(Math.max(y2-(H-h), 0), Math.max(h-y1, 0)));
            if (minDist == Integer.MAX_VALUE)
                minDist = -1;
            sb.append(minDist+"\n");
        }
        System.out.println(sb);
    }
}
