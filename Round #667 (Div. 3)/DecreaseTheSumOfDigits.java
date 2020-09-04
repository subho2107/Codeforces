import java.io.*;
import java.util.*;

public class DecreaseTheSumOfDigits {
    public static int getSumt(long num){
        int sum = 0;
        while (num != 0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        long a = Long.parseLong("1000000000000000000");
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long n = Long.parseLong(inp[0]);
            int s = Integer.parseInt(inp[1]);
            long sum = getSumt(n);
            String curr = Long.toString(n);
            int pos = curr.length()-1;
            String dest = "";
            int pow = 0;
            long ans = 0;
            while (sum > s ){
                if(pos < 0)
                    pos = 0;
                long temp = (long) (Math.pow(10, pow)*(10-Character.getNumericValue(curr.charAt(pos))));
                n+=temp;
                ans+=temp;
                curr = Long.toString(n);
                pos--;
                pow++;
                sum = getSumt(n);
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
