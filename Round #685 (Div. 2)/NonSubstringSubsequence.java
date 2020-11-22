import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NonSubstringSubsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
            String s = buffer.readLine();
            for (int query = 0; query < q; query++) {
                inp = buffer.readLine().split(" ");
                int l = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
                String substring = s.substring(l-1, r);
                l--;
                boolean check = false;
                for (int i = 1; i < substring.length(); i++) {
                    String pref = substring.substring(0, i), suff = substring.substring(i);
                    for (int j = 0; j < n; j++) {
                        check = false;
                        if (s.startsWith(pref, j)){
                            for (int k = j+pref.length()+1; k < n; k++) {
                                if (s.startsWith(suff, k)){
                                    check = true;
                                    break;
                                }
                            }
                        }
                        if (check)
                            break;
                    }
                    if (check)
                        break;
                }
                if (check)
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
