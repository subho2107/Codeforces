import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrisonBreak {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), r = Integer.parseInt(inp[2]), c = Integer.parseInt(inp[3]);
            int ans = 0;
            int [][] matrix = {{1,1}, {1,m}, {n, 1}, {n, m}};
            for (int [] arr : matrix) {
                    ans = Math.max(ans, Math.abs(arr[0] - r) + Math.abs(arr[1] - c));
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
