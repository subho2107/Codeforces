import java.io.*;
import java.util.*;

public class Suborrays {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            int or = 0;
            while(n!=0) {
                sb.append((n--)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
