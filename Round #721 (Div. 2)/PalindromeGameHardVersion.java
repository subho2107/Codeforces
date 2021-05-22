import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeGameHardVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] arr = buffer.readLine().toCharArray();
            int zero = 0, diff = 0;
            for (char ch : arr) {
                if (ch == '0')
                    zero++;
            }
            for (int i = 0; i < n/2; i++) {
                if (arr[i] != arr[n-i-1])
                    diff++;
            }
            if (diff == 0){
                if (zero % 2 == 0 || zero == 1)
                    sb.append("BOB\n");
                else
                    sb.append("ALICE\n");
            }
            else {
                if (zero == 2 && diff == 1)
                    sb.append("DRAW\n");
                else
                    sb.append("ALICE\n");
            }
        }
        System.out.println(sb);
    }
}
