import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MaxAndMex {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                s.add(Integer.parseInt(inp[i]));
            }
            int mex = 0, i;
            for (i = 1; i <= k; i++) {
                int  max = Collections.max(s);
                if (max == s.size()-1) {
                    i--;
                    break;
                }
                for (; mex < max + 2; mex++) {
                    if (!s.contains(mex))
                        break;
                }
                int newNum = (int) Math.ceil((mex+max)/2f);
                if (!s.add(newNum))
                    break;
//                sb.append(newNum).append(" ").append(s.toString()).append("\n");
            }
            int ans = s.size();
            if (Collections.max(s) == s.size()-1)
                ans += k-i;
            ans = Math.max(n, ans);
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
