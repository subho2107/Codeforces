import java.io.*;
import java.util.*;

public class DonutShops {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split( " ");
            long a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]);
            long shop1 = 0 , shop2 = 0;
            if (a >= c)
                shop1 = -1;
            if (b*a==c)
                shop2=-1;
            if (shop1==-1 && shop2==-1) {
                sb.append(shop1 + " " + shop2 + "\n");
                continue;
            }
            if (shop1!=-1) {
                if (a < c)
                    shop1 = 1;
                else if((b+1)*a < 2*c){
                    shop1 = b + 1;
                }
                else if((2*b+1)*a < 3*c)
                {
                    shop1 = 2*b+1;
                }
                else
                {
                    shop1 = -1;
                }
            }
            if (shop2!=-1)
            {
                if (c < a*b)
                    shop2=b;
                else if (2*c < a*2*b)
                    shop2=2*b;
                else
                    shop2=-1;
            }
            sb.append(shop1+" "+shop2+"\n");
        }
        System.out.println(sb);
    }
}
