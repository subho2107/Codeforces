import java.io.*;
import java.util.*;

public class LCMProblem {
    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String [] inp = bu.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            if (a*2<=b)
                sb.append(a+" "+(2*a)+"\n");
            else
                sb.append("-1 -1\n");
        }
        System.out.print(sb);
    }
}
