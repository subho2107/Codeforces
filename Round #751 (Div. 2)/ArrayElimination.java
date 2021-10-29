import java.io.*;
import java.util.*;

public class ArrayElimination {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] bits = new int[31];
            String [] inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                for (int j = 0; j < 31; j++) {
                    if ((num & (1<<j)) > 0)
                        bits[j]++;
                }
            }
            for (int i = 1; i <= n; i++) {
                boolean check = true;
                for (int bit : bits) {
                    if (bit % i != 0){
                        check = false;
                        break;
                    }
                }
                if (check)
                    sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
