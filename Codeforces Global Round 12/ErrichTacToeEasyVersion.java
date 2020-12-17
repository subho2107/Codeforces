import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ErrichTacToeEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] colors = {0,0,0};
            char [][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] inp = buffer.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = inp[j];
                    int color = (i+j)%3;
                    if (inp[j] == 'X')
                        colors[color]++;
                }
            }
            int minColor = -1, minCnt = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (colors[i] < minCnt){
                    minCnt = colors[i];
                    minColor = i;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'X' && (i+j)%3 == minColor)
                        matrix[i][j] = 'O';
                    sb.append(matrix[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
