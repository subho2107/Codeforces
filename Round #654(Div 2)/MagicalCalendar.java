import java.io.*;
import java.util.*;

public class MagicalCalendar {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split( " ");
            long n = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
            if (r < n)
                sb.append(r*(r+1)/2+"\n");
            else
            {
                n--;
                sb.append(n*(n+1)/2+1+"\n");
            }
        }
        System.out.println(sb);
    }
}
