import java.io.*;
import java.util.*;

public class OmkarAndCompletion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            for (int pos = 0; pos < n; pos++) {
                sb.append("1 ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
