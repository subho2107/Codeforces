import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class C {
    public static void updateVals(int[][]matrix, ArrayList<int[]>ones, ArrayList<int[]>zero, int i, int j){
        ones.clear();zero.clear();
        for (int k = i; k < i+2; k++) {
            for (int l = j; l < j+2; l++) {
                if (matrix[k][l] == 1)
                    ones.add(new int[]{k, l});
                else
                    zero.add(new int[]{k, l});
            }
        }
    }
    public static void printMatrix(int [][] matrix, int n){
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }
    public static void change(int [][] matrix, int [] a, int [] b, int [] c){
        matrix[a[0]][a[1]] ^= 1;
        matrix[b[0]][b[1]] ^= 1;
        matrix[c[0]][c[1]] ^= 1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String temp = buffer.readLine();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Character.getNumericValue(temp.charAt(j));
                }
            }
            StringBuilder sbTemp = new StringBuilder();
            int operations = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    ArrayList<int[]>ones = new ArrayList<>(), zero = new ArrayList<>();
                    updateVals(matrix, ones, zero, i, j);
                    if (ones.size() == 4){
                        operations++;
                        sbTemp.append(i + 1).append(" ").append(j + 1).append(" ").append(i + 2).append(" ").append(j + 2).append(" ").append(i + 1).append(" ").append(j + 2).append("\n");
                        matrix[i][j] = 0;matrix[i+1][j+1] = 0; matrix[i][j+1] = 0;
                    }
                    updateVals(matrix, ones, zero, i, j);
                    if (ones.size() == 1){
                        operations++;
                        int [] a = ones.get(0), b = zero.get(0), c = zero.get(1);
                        sbTemp.append(a[0]+1).append(" ").append(a[1]+1).append(" ").append(b[0]+1).append(" ").append(b[1]+1).append(" ").append(c[0]+1).append(" ").append(c[1]+1).append("\n");
                        change(matrix, a, b, c);

                    }
                    updateVals(matrix, ones, zero, i, j);
                    if (ones.size() == 2){
                        operations++;
                        int [] a = ones.get(0), b = zero.get(0), c = zero.get(1);
                        sbTemp.append(a[0]+1).append(" ").append(a[1]+1).append(" ").append(b[0]+1).append(" ").append(b[1]+1).append(" ").append(c[0]+1).append(" ").append(c[1]+1).append("\n");
                        change(matrix, a, b, c);
                    }
                    updateVals(matrix, ones, zero, i, j);
                    if (ones.size() == 3){
                        operations++;
                        int [] a = ones.get(0), b = ones.get(1), c = ones.get(2);
                        sbTemp.append(a[0]+1).append(" ").append(a[1]+1).append(" ").append(b[0]+1).append(" ").append(b[1]+1).append(" ").append(c[0]+1).append(" ").append(c[1]+1).append("\n");
                        change(matrix, a, b, c);
                    }
                    if (!(m % 2 == 1 && j == m-3))
                        j++;
                    printMatrix(matrix, n);
                }
                if (!(n % 2 == 1 && i == n-3))
                    i++;
            }
            printMatrix(matrix, n);
//            if (operations > n*m)
//                throw new Exception("WA");
            sb.append(operations+"\n");
            sb.append(sbTemp);
        }
        System.out.println(sb);
    }
}
