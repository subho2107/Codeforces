import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FibonacciWords {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String s = buffer.readLine();
            if (s.length() <= 2)
                System.out.println("YES");
            else {
                boolean check = true;
                for (int i = 2; i < s.length(); i++) {
                    int c = s.charAt(i) - 'A', b = s.charAt(i-1) -'A', a = s.charAt(i-2) - 'A';
                    if (c != (a+b)%26)
                    {
                        check = false;
                        break;
                    }
                }
                if (check)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
        System.out.println(sb);
    }
}
