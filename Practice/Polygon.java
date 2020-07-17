import java.io.*;
import java.util.*;

public class Polygon {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] inp;
            char [][] matrix = new char[n][n];
            for(int rowPos = 0; rowPos < n; rowPos++)
            {
                inp = buffer.readLine().toCharArray();
                for(int colPos = 0; colPos < n; colPos++)
                {
                    matrix[rowPos][colPos] = inp[colPos];
                }
            }
            boolean check = true;
            for (int rowPos = 0; rowPos < n - 1; rowPos++) {
                for (int colPos = 0; colPos < n - 1; colPos++) {
                    if (matrix[rowPos][colPos]=='1' && matrix[rowPos+1][colPos]!='1' && matrix[rowPos][colPos+1]!='1') {
                        check = false;
                        break;
                    }
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
