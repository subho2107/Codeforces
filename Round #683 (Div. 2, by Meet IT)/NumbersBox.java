import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumbersBox {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [][] matrix = new int[n][m];
            long ans = 0;
            int cntNegative = 0;
            int minElement = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(inp[j]);
                    minElement = Math.min(minElement, Math.abs(matrix[i][j]));
                    ans += Math.abs(matrix[i][j]);
                    if (matrix[i][j]<0)
                        cntNegative++;
                }
            }
            if (cntNegative % 2 == 1)
                ans -= 2*minElement;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
