import java.io.*;
import java.util.*;

public class MinimumProduct {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), x = Integer.parseInt(inp[2]), y = Integer.parseInt(inp[3]), n = Integer.parseInt(inp[4]);
            if (a > b){
                a = a^b^(b = a);
                x = y^x^(y = x);
            }
            if (Math.max(a-n, x)<Math.max(b-n, y)) {
                a -= n;
                int diff = 0;
                if (a < x) {
                    diff = x - a;
                    a = x;
                }
                b -= diff;
                if (b < y)
                    b = y;
            }
            else {
                b -= n;
                int diff = 0;
                if (b < y) {
                    diff = y - b;
                    b = y;
                }
                a -= diff;
                if (a<x)
                    a = x;
            }

            sb.append((long)a*(long)b).append("\n");
        }
        System.out.println(sb);
    }
}