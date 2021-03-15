import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlexeyAndTrain {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp;
            int [][] timings = new int[n][2];
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                timings[i][0] = Integer.parseInt(inp[0]);
                timings[i][1] = Integer.parseInt(inp[1]);
            }
            inp = buffer.readLine().split(" ");
            int [] delays = new int[n];
            for (int i = 0; i < n; i++) {
                delays[i] = Integer.parseInt(inp[i]);
            }
            int reachTime = delays[0]+timings[0][0];
            for (int i = 0; i < n - 1; i++) {
                int leavingTime = (int) Math.max(reachTime+Math.ceil((timings[i][1] - timings[i][0])/2f), timings[i][1]);
                reachTime = leavingTime+timings[i+1][0] - timings[i][1] + delays[i+1];
            }
            sb.append(reachTime).append("\n");
        }
        System.out.println(sb);
    }
}
