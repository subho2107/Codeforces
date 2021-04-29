import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fillomino2 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int[][] matrix = new int[n][n];
            String[] inp = buffer.readLine().split(" ");
            ArrayList<Integer>permutation = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                permutation.add(Integer.parseInt(inp[i]));
            }
            int a = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0, k = 0; j < n; j++) {
                    if (j + i >= n)
                        break;
                    while (k < permutation.size() && permutation.get(k) <= a)
                        k++;
                    matrix[j+i][j] = permutation.get(k);
                    k++;
                }
                a++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(matrix[i][j]+" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
