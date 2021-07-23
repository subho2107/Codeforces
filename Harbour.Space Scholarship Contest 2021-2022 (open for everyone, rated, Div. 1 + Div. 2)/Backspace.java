import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backspace {
    public static boolean isPossible(String s, String t){
        int i = s.length()-1, j = t.length()-1;
        int prev = i;
        while (i >= 0 && j >= 0){
            if (s.charAt(i) == t.charAt(j) && (prev-i)% 2 == 0 ){
                j--;
                prev = i-1;
            }
            i--;
        }
        return j == -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s1 = buffer.readLine(), s2 = buffer.readLine();
            int diff = s1.length() - s2.length();
            if (diff >= 0 && isPossible(s1, s2))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
