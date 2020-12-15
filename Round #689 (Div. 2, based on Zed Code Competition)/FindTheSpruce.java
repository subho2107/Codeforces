import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindTheSpruce {
    public static int getMaxK(int row, int col, int [][] matrix, int [][] prefixSum){
        int n = matrix.length, m = matrix[0].length;
        int k = 0, size = 0;
        boolean check = true;
        while (row < n && col + size < m && col-size >= 0 && check){
            int colStart = col-size, colEnd = col+size;
            int stars = prefixSum[row][colEnd];
            if (colStart != 0)
                stars -= prefixSum[row][colStart-1];
            if (stars == colEnd - colStart + 1)
                k++;
            else
                check = false;
            row++;
            size++;
        }
        return k;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [][] matrix = new int[n][m];
            int [][] prefixSum = new int[n][m];
            for (int i = 0; i < n; i++) {
                char [] s = buffer.readLine().toCharArray();
                int cnt = 0;
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = s[j];
                    if (matrix[i][j] == '*')
                        cnt++;
                    prefixSum[i][j] = cnt;
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == '*'){
                        cnt += getMaxK(i, j, matrix, prefixSum);
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
