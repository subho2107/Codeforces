import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeGameEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] ch = buffer.readLine().toCharArray();
            int zero = 0;
            for (char c : ch) {
                if (c == '0')
                    zero++;
            }
            if (zero % 2 == 0 || zero == 1)
                sb.append("BOB\n");
            else
                sb.append("ALICE\n");
        }
        System.out.println(sb);
    }
}
