import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BusyRobot {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int cnt = 0;
            int[][] queries = new int[n + 1][2];
            for (int i = 0; i < n; i++) {
                String[] inp = buffer.readLine().split(" ");
                queries[i][0] = Integer.parseInt(inp[0]);
                queries[i][1] = Integer.parseInt(inp[1]);
            }
            queries[n][0] = Integer.MAX_VALUE;
            int destination = queries[0][1], source = 0, timeNeeded = destination - source;
            for (int i = 1; i < n + 1; i++) {
                if (queries[i][0] < timeNeeded)
                    continue;
                if (queries[i - 1][1] >= source && queries[i - 1][1] <= destination)
                    cnt++;
                source = destination;
                destination = queries[i][1];
                timeNeeded += destination - source;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}