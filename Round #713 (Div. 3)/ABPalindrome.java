import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABPalindrome {
    public static boolean isPalin(char[]chars){
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length-i-1])
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            char[] s = buffer.readLine().toCharArray();
            int one = 0, zero = 0;
            for (char ch : s) {
                if (ch == '0')
                    zero++;
                else if (ch == '1')
                    one++;
            }
            zero = a - zero;
            one = b - one;
            boolean check = true;
            int n = s.length;
            for (int i = 0; i < n / 2; i++) {
                if (s[i] != '?' && s[n - i - 1] != '?')
                    continue;
                if (s[i] != s[n - i - 1]) {
                    if (s[i] == '?'){
                        if (s[n-i-1] == '1' && one >=1){
                            s[i] = '1';
                            one--;
                        }
                        else if (s[n-i-1] == '0' && zero >= 1)
                        {
                            s[i] = '0';
                            zero--;
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
                    else {
                        if (s[i] == '1' && one >=1){
                            s[n-i-1] = '1';
                            one--;
                        }
                        else if (s[i] == '0' && zero >= 1)
                        {
                            s[n-i-1] = '0';
                            zero--;
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < n / 2; i++) {
                if (s[i] == '?' && s[n-i-1] == '?'){
                    if (zero > one && zero >= 2) {
                        s[i] = '0';
                        s[n - i - 1] = '0';
                        zero -= 2;
                    }
                    else if (one >= 2){
                        s[i] = '1';
                        s[n-i-1] = '1';
                        one -= 2;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }
            if (n % 2 == 1 && s[n/2] == '?'){
                if (zero >= 1) {
                    s[n / 2] = '0';
                    zero--;
                }
                else if (one >= 1) {
                    s[n / 2] = '1';
                    one--;
                }
                else
                    check = false;
            }
            if (zero != 0 || one != 0 || !isPalin(s) )
                check = false;

            if (check)
            {
                for (char ch : s) {
                    sb.append(ch);
                }
                sb.append("\n");
            }
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}