import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NotAdjacentMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [][] matrix = new int[n][n];
            int num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = num;
                    num += 2;
                    if (num > n*n)
                        num = 2;
                }
            }
            boolean check = true;
            int [][] pos = {{-1, 0}, {0, -1}, {1, 0}, {1, 0}};
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] index : pos) {
                        if( (i+index[0] < n && i+index[0] >= 0 && j+index[1] < n && j+index[1] >= 0) && Math.abs(matrix[i][j] - matrix[i+index[0]][j+index[1]])==1)
                        {
                            check = false;
                            break;
                        }

                    }
                    if (!check)
                        break;
                }
                if (!check)
                    break;
            }
            if (!check)
                sb.append("-1\n");
            else {
                for (int i = 0; i < n; i++) {
                    for (int a : matrix[i]) {
                        sb.append(a+" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
