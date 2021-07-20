import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PuttingPlates {
    public static boolean checkValid(int [][]matrix, int i, int j, int h, int w){
        if (matrix[i][j] == 1)
            return false;
        if (i - 1>= 0 && j - 1>= 0 && matrix[i-1][j-1] == 1)
            return false;
        if (i - 1>= 0 && matrix[i-1][j] == 1)
            return false;
        if (j - 1>= 0 && matrix[i][j-1] == 1)
            return false;
        if (i+1 < h && matrix[i+1][j] == 1)
            return false;
        if (j+1 < w && matrix[i][j+1] == 1)
            return false;
        if (i+1 < h && j+1 < w && matrix[i+1][j+1] == 1)
            return false;
        if (i - 1>= 0 && j+1 < w && matrix[i-1][j+1] == 1)
            return false;
        if (i+1 < h && j - 1 >= 0 && matrix[i+1][j-1] == 1)
            return false;
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int h = Integer.parseInt(inp[0]), w = Integer.parseInt(inp[1]);
            int [][] matrix = new int[h][w];
            for (int i = 0; i < w; i+=2) {
                matrix[0][i] = 1;
            }
            for (int i = 2; i < h; i++) {
                if (checkValid(matrix, i, 0, h, w))
                matrix[i][0] = 1;
            }
            for (int i = 0; i < w; i++) {
                if (checkValid(matrix, h-1, i, h, w))
                matrix[h-1][i] = 1;
            }
            for (int i = 0; i < h; i++) {
                if (checkValid(matrix, i, w-1, h, w))
                matrix[i][w-1] = 1;
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(matrix[i][j]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
