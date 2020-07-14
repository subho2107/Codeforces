import java.io.*;
import java.util.*;

public class OmkarAndLastClassOfMath {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            if (n % 2 == 0)
                sb.append(n / 2).append(" ").append(n / 2).append('\n');
            else
            {
                boolean check = false;
                for (int fact = 2; fact <= (int)Math.sqrt(n); fact++) {
                    if (n%fact==0)
                    {
                        check = true;
                        sb.append(n/fact).append(" ").append(n-n/fact).append("\n");
                        break;
                    }
                }
                if (!check)
                    sb.append(1).append(" ").append(n-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
