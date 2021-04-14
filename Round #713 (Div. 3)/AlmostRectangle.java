import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlmostRectangle {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char[][] matrix = new char[n][n];
            int[] a = new int[2], b = new int[2];
            boolean check = false;
            for (int i = 0; i < n; i++) {
                char[] inp = buffer.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = inp[j];
                    if (matrix[i][j] == '*') {
                        if (!check) {
                            check = true;
                            a[0] = i;
                            a[1] = j;
                        }
                        else
                        {
                            b[0] = i;
                            b[1] = j;
                        }
                    }
                }
            }
            if (!(a[0] == b[0] || a[1] == b[1])) {
                matrix[a[0]][b[1]] = '*';
                matrix[b[0]][a[1]] = '*';
            }
            else {
                if (a[0] == b[0]){
                    if (a[0]-1>=0){
                        matrix[a[0]-1][a[1]] = '*';
                        matrix[a[0]-1][b[1]] = '*';
                    }else {
                        matrix[a[0]+1][a[1]] = '*';
                        matrix[a[0]+1][b[1]] = '*';
                    }
                }
                else {
                    if (a[1]-1>=0){
                        matrix[a[0]][a[1]-1] = '*';
                        matrix[b[0]][b[1]-1] = '*';
                    }else {
                        matrix[a[0]][a[1]+1] = '*';
                        matrix[b[0]][b[1]+1] = '*';
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}