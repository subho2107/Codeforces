import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Triangles {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int[][][] rowWiseExtremes = new int[n][10][2], colWiseExtremes = new int[n][10][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    Arrays.fill(rowWiseExtremes[i][j], -1);
                    Arrays.fill(colWiseExtremes[i][j], -1);
                }
            }
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                char[] inp = buffer.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Character.getNumericValue(inp[j]);
                }
            }
            int[][] minMaxVertices = new int[10][4];
            for (int[] minMaxVertex : minMaxVertices) {
                Arrays.fill(minMaxVertex, -1);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rowWiseExtremes[i][matrix[i][j]][0] == -1)
                        rowWiseExtremes[i][matrix[i][j]][0] = j;
                    rowWiseExtremes[i][matrix[i][j]][1] = j;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (colWiseExtremes[i][matrix[j][i]][0] == -1)
                        colWiseExtremes[i][matrix[j][i]][0] = j;
                    colWiseExtremes[i][matrix[j][i]][1] = j;
                }
            }
            for (int d = 0; d < 10; d++) {
                for (int i = 0; i < n; i++) {
                    if (minMaxVertices[d][0] == -1)
                        minMaxVertices[d][0] = rowWiseExtremes[i][d][0];
                    else if (rowWiseExtremes[i][d][0] != -1)
                        minMaxVertices[d][0] = Math.min(minMaxVertices[d][0], rowWiseExtremes[i][d][0]);
                    minMaxVertices[d][1] = Math.max(minMaxVertices[d][1], rowWiseExtremes[i][d][1]);

                    if (minMaxVertices[d][2] == -1)
                        minMaxVertices[d][2] = colWiseExtremes[i][d][0];
                    else if (colWiseExtremes[i][d][0] != -1)
                        minMaxVertices[d][2] = Math.min(minMaxVertices[d][2], colWiseExtremes[i][d][0]);
                    minMaxVertices[d][3] = Math.max(minMaxVertices[d][3], colWiseExtremes[i][d][1]);
                }
            }
            long[] ans = new long[10];
            for (int d = 0; d < 10; d++) {
                int base, height;
                for (int i = 0; i < n; i++) {
                    int a = rowWiseExtremes[i][d][1], b = rowWiseExtremes[i][d][0];
                    if (!(a == b && a == -1)) {
                        base = Math.abs(b - a);
                        height = Math.max(i-minMaxVertices[d][2], minMaxVertices[d][3] - i);
                        ans[d] = Math.max(ans[d], (long) base * height);
                        ans[d] = Math.max(ans[d], (long) base * Math.max(i, n - 1 - i));
                        ans[d] = Math.max(ans[d], (long) height * Math.max(a, b));
                    }
                    a = colWiseExtremes[i][d][1];
                    b = colWiseExtremes[i][d][0];
                    if (!(a == b && a == -1)) {
                        base = Math.abs(b - a);
                        height = Math.max(i-minMaxVertices[d][0], minMaxVertices[d][1] - i);
                        ans[d] = Math.max(ans[d], (long) base * height);
                        ans[d] = Math.max(ans[d], (long) base * Math.max(i, n - 1 - i));
                        ans[d] = Math.max(ans[d], (long) height * (n-1 - (Math.min(a,b)==-1?Math.max(a, b):Math.min(a, b))));
                        ans[d] = Math.max(ans[d], (long) height * Math.max(a, b));
                    }
                }
            }
                for (long area : ans)
                    sb.append(area).append(" ");
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
