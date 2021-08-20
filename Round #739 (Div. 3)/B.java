import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]);
            int ans = -1;
            if (a > b)
                a = a^b^(b = a);
            int n = (b-a)*2;
            if (c > n || a > n || b > n){
                sb.append(-1+"\n");
                continue;
            }
//            if (c > a && c < b){
//                ans = ((c-a)+b)%n;
//                if (ans == 0)
//                    ans = n;
//            }
//            else if (c > b && c < 1){
//                ans = (c-b)+a;
//            }
//            else if (c >= 1 && c < a){
//                ans = b-(a-c);
//            }
            ans = (c-b+a+n)%n;
            if (ans == 0)
                ans = n;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
