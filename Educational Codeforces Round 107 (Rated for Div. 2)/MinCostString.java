import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinCostString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            StringBuilder temp = new StringBuilder();
            for (char i = 'a'; i < 'a'+k; i++) {
                temp.append(i);
                for (char j = (char) (i+1); j < 'a'+k; j++) {
                    temp.append(i);
                    temp.append(j);
                }
            }
            StringBuilder ans = new StringBuilder();
            while (ans.length() < n)
                ans.append(temp);
            for (int i = 0; i < n; i++) {
                sb.append(ans.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
