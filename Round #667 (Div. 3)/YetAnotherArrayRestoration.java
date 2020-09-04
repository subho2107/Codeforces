import java.io.*;
import java.util.*;

public class YetAnotherArrayRestoration {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp =buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), a = Integer.parseInt(inp[1]), b = Integer.parseInt(inp[2]);
            int diff = b-a;
            for (int i = n-1; i >= 1 ; i--) {
                if ((b-a)%i==0){
                    diff = (b-a)/i;
                    break;
                }
            }
            sb.append(a+" "+b+" ");
            for (int i = a+diff; i < b; i+=diff) {
                sb.append(i+" ");
            }
            int cnt =((b-a)/diff)+1;
            cnt = n-cnt;
            while (a-diff > 0 && cnt>0){
                a-=diff;
                sb.append(a+" ");
                cnt--;
            }
            while (cnt>0){
                b+=diff;
                sb.append(b+" ");
                cnt--;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
