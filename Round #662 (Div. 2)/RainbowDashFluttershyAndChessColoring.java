import java.io.*;
import java.util.*;

public class RainbowDashFluttershyAndChessColoring {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            sb.append(((n/2)+1)+"\n");
        }
        System.out.println(sb);
    }
}
