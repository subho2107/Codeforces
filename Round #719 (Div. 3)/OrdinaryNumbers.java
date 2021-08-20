import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OrdinaryNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<Long>list = new ArrayList<>();
            int len = Integer.toString(n).length();
            for (int i = 1; i < 10; i++) {
                list.add(Long.parseLong(Integer.toString(i).repeat(len)));
            }
            long ans = 0;
            for (Long num : list) {
                ans += len-1;
                if (n >= num)
                    ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
