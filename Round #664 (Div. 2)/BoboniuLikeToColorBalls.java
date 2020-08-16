import java.io.*;
import java.util.*;

public class BoboniuLikeToColorBalls {
    public static boolean check(int a, int b, int c, int d){
        int cnt = 0;
        if (a % 2 == 1) cnt++;
        if (b % 2 == 1) cnt++;
        if (c % 2 == 1) cnt++;
        if (d % 2 == 1) cnt++;
        return cnt <= 1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" " );
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c= Integer.parseInt(inp[2]),
                    d = Integer.parseInt(inp[3]);
            if (a==0 && b==0 && c == 0 )
                sb.append("YES\n");
            else {
                if (a!=0 && b!=0 && c!=0){
                    if (check(a, b, c, d))
                        sb.append("YES\n");
                    else if (check(a-1, b-1, c-1, d+3))
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
                else
                {
                    if (check(a, b, c, d))
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
