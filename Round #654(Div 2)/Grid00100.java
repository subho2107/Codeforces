import java.io.*;
import java.sql.Array;
import java.util.*;

public class Grid00100 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int cnt1 = k, cnt0 = n*n-k;
            int [][] matrix = new int[n][n];
            if (k%n==0)
                sb.append("0\n");
            else
                sb.append("2\n");
            int rowPos = 0, colPos= 0;
            while (k-->0)
            {
                matrix[rowPos][colPos] = 1;
                rowPos++;
                colPos++;
                colPos%=n;
                if (rowPos==n)
                {
                    rowPos = 0;
                    colPos++;
                    colPos %= n;
                }
            }
            for (rowPos = 0; rowPos < n; rowPos++) {
                for (colPos = 0; colPos < n; colPos++) {
                    sb.append(matrix[rowPos][colPos]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
