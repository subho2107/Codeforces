import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RandomEvents {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [] arr = new int[n];
            inp = buffer.readLine().split(" ");
            int lastUnsorted = -1;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (arr[i] != i+1)
                    lastUnsorted = i+1;
            }
            double probAns = 1;
            for (int i = 0; i < m; i++) {
                inp = buffer.readLine().split(" ");
                int expNo = Integer.parseInt(inp[0]);
                double prob = Float.parseFloat(inp[1]);
                if (expNo >= lastUnsorted && lastUnsorted != -1)
                probAns *= 1-prob;
            }
            if (lastUnsorted == -1){
                sb.append("1.000000\n");
                continue;
            }
            probAns = 1 - probAns;
            sb.append(probAns+"\n");
        }
        System.out.println(sb);
    }
}
