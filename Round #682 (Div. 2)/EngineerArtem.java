import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EngineerArtem {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(inp[j]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!(i == 0 && j == 0)){
                        if (j == 0){
                            if (matrix[i][j] % 2 == matrix[i-1][j] % 2)
                                matrix[i][j]++;
                        }
                        else {
                            if (matrix[i][j] % 2 == matrix[i][j-1] % 2)
                                matrix[i][j]++;
                        }
                    }
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
