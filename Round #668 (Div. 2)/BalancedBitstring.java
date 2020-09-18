import java.io.*;
import java.util.*;

public class BalancedBitstring {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            String s = buffer.readLine();
            boolean check = true;
            int zero = 0, one = 0;
            for (int pos = 0; pos < k; pos++) {
                int temp = -1;
                for (int inPos = pos; inPos < n; inPos+=k) {
                    if (s.charAt(inPos)!='?'){
                        if(temp != -1 && Character.getNumericValue(s.charAt(inPos))!=temp){
                            check = false;
                            break;
                        }
                        temp = Character.getNumericValue(s.charAt(inPos));
                    }
                }
                if (temp != -1){
                    if (temp == 0)zero++;
                    else one++;
                }
            }
            if (Math.max(zero, one)>k/2)
                check = false;
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
