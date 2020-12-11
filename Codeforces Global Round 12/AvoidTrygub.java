import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AvoidTrygub {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            String temp = "trygub";
            int j = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (j < temp.length() && s.charAt(i) == temp.charAt(j))
                    j++;
                if (s.charAt(i) == 'r')
                    cnt++;
            }
            if (j != 6)
                sb.append(s).append("\n");
            else {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    ans.append('r');
                }
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) != 'r')
                        ans.append(s.charAt(i));
                }
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
}
