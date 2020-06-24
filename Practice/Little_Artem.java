import java.io.*;
import java.util.*;

public class Little_Artem {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int row = Integer.parseInt(inp[0]), col= Integer.parseInt(inp[1]);
            for (int rowPos = 0; rowPos < row; rowPos++) {
                for (int colPos = 0; colPos < col; colPos++) {
                    if (colPos==0 && rowPos==0)sb.append("W");
                    else sb.append("B");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
