import java.io.*;
import java.util.*;

public class TernarySequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x0 = Integer.parseInt(inp[0]), y1 = Integer.parseInt(inp[1]), z2 = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            int x00 = Integer.parseInt(inp[0]), y11 = Integer.parseInt(inp[1]), z22 = Integer.parseInt(inp[2]);
            long sum = 0;
            int temp = Math.min(z2, y11);
            sum += temp*2;
            z2-= temp;y11-=temp;

            temp = Math.min(z22, x0);
            z22-=temp;x0-=temp;
            temp = Math.min(z22, z2);
            z22-=temp;z2-=temp;
            if (z22!=0)
            {
                temp = Math.min(z22, y1);
                sum -= temp*2;
                z22 -= temp;
                y1 -= temp;
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
