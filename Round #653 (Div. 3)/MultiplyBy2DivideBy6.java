import java.io.*;
import java.util.*;

public class MultiplyBy2DivideBy6 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(buffer.readLine());
            long cnt = 0;
            while (num > 1)
            {
                if (num%6==0)
                    num/=6;
                else
                    num*=2;
                cnt++;
            }
            if (num==1)
                sb.append(cnt+"\n");
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
