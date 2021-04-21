import java.io.*;
public class DejaVu {
    public static boolean isPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        for (int test = 1; test <= t; test++){
            String s = buffer.readLine();
            int n = s.length();
            boolean done = false;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i < n / 2 && !done && s.charAt(n - i - 1) != 'a') {
                    ans.append('a');
                    done = true;
                }
                ans.append(s.charAt(i));
            }
            if (!done){
                ans = new StringBuilder();
                for (int i = n-1; i >= 0; i--) {
                    if (i > n / 2 && !done && s.charAt(n - i - 1) != 'a') {
                        ans.append('a');
                        done = true;
                    }
                    ans.append(s.charAt(i));
                }
                ans = ans.reverse();
            }
            if (!done && ((n % 2 == 1 && s.charAt(n / 2) != 'a') ||(!isPalin(s) && n % 2 == 0))) {
                ans = new StringBuilder(s.substring(0, n / 2) + 'a' + s.substring(n / 2));
                done = true;
            }
            if (done) {
                sb.append("YES\n");
                sb.append(ans).append("\n");
            } else
                System.out.println(sb);
            sb.append("NO\n");
        }
    }
}
//baaaaaaaa