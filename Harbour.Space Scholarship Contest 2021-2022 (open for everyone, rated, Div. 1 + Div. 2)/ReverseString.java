import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class ReverseString {
    public static boolean isPalin(String  s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s1 = buffer.readLine(), s2 = buffer.readLine();
            int n = s1.length();
            HashSet<String>substrings = new HashSet<>();
            for (int i = 0; i < n; i++) {
                StringBuilder curr = new StringBuilder();
                for (int j = i; j < n; j++) {
                    curr.append(s1.charAt(j));
                    substrings.add(curr.toString());
                }
            }
            ArrayList<String>reverseStrings = new ArrayList<>();
            StringBuilder curr = new StringBuilder();
            int m = s2.length();
            for (int i = m-1; i >= 0; i--) {
                curr.append(s2.charAt(i));
                reverseStrings.add(curr.toString());
            }
            boolean check = false;
            if (substrings.contains(s2)){
                sb.append("YES\n");
                continue;
            }
            curr = new StringBuilder();
            for (int i = 0; i < m; i++) {
                curr.append(s2.charAt(i));
                if (!substrings.contains(curr.toString()))
                    continue;
                int j = i-1, k = i+1;
                while (j >= 0 && k < m && s2.charAt(j)==s2.charAt(k))
                {
                    j--;
                    k++;
                }
                if (k == m){
                    check = true;
                    break;
                }
                String temp = reverseStrings.get(m-1-k)+ curr;
                if (substrings.contains(temp) && i == k-i-1){
                    check = true;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
