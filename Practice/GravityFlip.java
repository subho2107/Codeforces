import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GravityFlip {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int col = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] stacks = new int[col];
            int row = 0;
            for (int i = 0; i < col; i++) {
                stacks[i] = Integer.parseInt(inp[i]);
                row = Math.max(row, stacks[i]);
            }
            int [][] matrix = new int[row][col];
            int [] onesInRow = new int[row];
            for (int i = 0; i < row; i++) {
                int cnt = 0;
                for (int j = 0; j < col; j++) {
                    if (i>=row-stacks[j])
                        cnt++;
                }
                onesInRow[i] = cnt;
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j >= col-onesInRow[i])
                        matrix[i][j] = 1;
                }
            }
            for (int i = 0; i < col; i++) {
                int cnt = 0;
                for (int j = 0; j < row; j++) {
                    if (matrix[j][i] == 1)
                        cnt++;
                }
                sb.append(cnt+" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
