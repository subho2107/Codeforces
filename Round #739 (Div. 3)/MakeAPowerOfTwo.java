import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {
    public static boolean isSubsequence(String str1, String str2){
        int j = 0, m = str1.length(), n = str2.length();
        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        return (j == m);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            long toNum = 1, ans = Integer.MAX_VALUE;
            while (toNum <= 1e18){
                String from = Long.toString(n), to = Long.toString(toNum);
                for (int i = 0; i < Math.min(to.length(), from.length()); i++) {
                    if (isSubsequence(to.substring(0, i+1), from)){
                        ans = Math.min(ans, from.length()-(i+1)+to.length()-(i+1));
                    }
                }
                toNum *= 2;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
