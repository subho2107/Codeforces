import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BoxIsPull {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x1 = Integer.parseInt(inp[0]), y1 = Integer.parseInt(inp[1]), x2 = Integer.parseInt(inp[2]), y2 = Integer.parseInt(inp[3]);
            int xDiff = Math.abs(x1-x2), yDiff = Math.abs(y1-y2);
            if (xDiff == 0 || yDiff == 0){
                sb.append(Math.max(xDiff, yDiff)+"\n");
            }
            else {
                long res = xDiff + yDiff + 2;
                sb.append(res+"\n");
            }
        }
        System.out.println(sb);
    }
}
