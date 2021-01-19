import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringLCM {
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine(), s2 = buffer.readLine();
            int a = 0, b = 0;
            int length = lcm(s.length(), s2.length());
            for (char ch : s.toCharArray()) {
                if (ch == 'a')
                    a++;
                else
                    b++;
            }
            if (a== 0 || b == 0){
                int a2 = 0, b2 = 0;
                for (char ch : s2.toCharArray()) {
                    if (ch == 'a')
                        a2++;
                    else
                        b2++;
                }
                if (a2 == 0 || b2 == 0){
                    if ((a != 0 && a2 != 0)||(b !=0 && b2 != 0))
                    {
                        char temp = 'a';
                        if (b !=0)
                            temp = 'b';
                        for (int i = 0; i < length; i++) {
                            sb.append(temp);
                        }
                        sb.append("\n");
                    }
                    else
                        sb.append("-1\n");
                }
                else
                    sb.append("-1\n");
            }
            else
            {
                if (s.length() > s2.length()) {
                    String temp = s;
                    s = s2;
                    s2 = temp;
                }
                StringBuilder temp = new StringBuilder();
                while (temp.length() != length)
                    temp.append(s2);
                s2 = temp.toString();
                boolean check = true;
                for (int i = 0; i < s2.length(); i += s.length()) {
                    if (!s2.startsWith(s, i)) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    sb.append(s2).append("\n");
                else
                    sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}
