import java.io.*;
import java.util.*;

public class CaptainFlintAndCrewRecruitment {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            if(n<= 30)
                sb.append("NO\n");
            else {
                int a = 6, b = 10, c = 14;
                if (n-30==a||n-30==b||n-30==c)
                    c = 15;
                if (a+b+c<n){
                    sb.append("YES\n");
                    sb.append(a+" "+b+" "+c+" "+(n-(a+b+c))+"\n");
                }
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
