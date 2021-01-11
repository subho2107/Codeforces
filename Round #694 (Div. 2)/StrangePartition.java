import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StrangePartition {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            long maxVal = 0, minVal = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                maxVal += num/x;
                if (num % x != 0)
                    maxVal++;
                minVal += num;
            }
            if (minVal % x != 0)
                minVal = minVal/x + 1;
            else
                minVal /= x;
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.println(sb);
    }
}
