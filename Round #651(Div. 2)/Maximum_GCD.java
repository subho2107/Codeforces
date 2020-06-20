import java.io.*;
import java.util.*;

public class Maximum_GCD {
    public static int gcd(int a , int b)
    {
        if (a == 0)return b;
        return gcd(b%a,a);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        for (int num = 1; num < 20; num++) {
//            for (int num2 = num+1; num2 < 20; num2++) {
//                System.out.println(num+" "+num2+" "+gcd(num, num2));
//            }
//
//        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int maxGCD = -1;
            for (int num = 1; num <= n; num++) {
                if (n/num>= 2)
                {
                    maxGCD = Math.max(maxGCD,num);
                }
            }
            maxGCD = (maxGCD >= 1)?maxGCD:1;
            sb.append(maxGCD+"\n");
        }
        System.out.println(sb);
    }
}
