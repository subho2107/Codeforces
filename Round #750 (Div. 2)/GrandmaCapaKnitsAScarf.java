import java.io.*;
import java.util.*;

public class GrandmaCapaKnitsAScarf {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            Set<Character>chars = new HashSet<>();
            for (char c : s.toCharArray()) {
                chars.add(c);
            }
            int ans = Integer.MAX_VALUE;
            for (Character aChar : chars) {
                int cnt = 0, l = 0, r = s.length()-1;
                while (l < r){
                    if (s.charAt(l) == s.charAt(r)){
                        l++;
                        r--;
                    }
                    else if (s.charAt(l) == aChar){
                        l++;
                        cnt++;
                    }
                    else if (s.charAt(r) == aChar) {
                        r--;
                        cnt++;
                    }
                    else {
                        cnt = -1;
                        break;
                    }
                }
                if (cnt != -1)
                    ans = Math.min(ans, cnt);
            }
            ans = ans == Integer.MAX_VALUE?-1:ans;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
