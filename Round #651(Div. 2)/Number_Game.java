import java.io.*;

public class Number_Game {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            if (n==1)sb.append("FastestFinger\n");
            else if (n==2||n%2!=0)sb.append("Ashishgup\n");
            else
            {
                int divisorsOf2= 0, divisorsOfOdds = 0;
                while (n%2==0)
                {
                    n/=2;
                    divisorsOf2++;
                }
                for(int fact = 3; fact*fact <= n; fact+=2)
                {
                    while (n%fact==0)
                    {
                        n /= fact;
                        divisorsOfOdds++;
                    }
                }
                if (n==2)divisorsOf2++;
                if (n>2)divisorsOfOdds++;
                if (divisorsOf2>1)
                {
                    if (divisorsOfOdds >=1)sb.append("Ashishgup\n");
                    else sb.append("FastestFinger\n");
                }
                else
                {
                    if (divisorsOfOdds>1)sb.append("Ashishgup\n");
                    else sb.append("FastestFinger\n");
                }
            }
        }
        System.out.println(sb);
    }
}
