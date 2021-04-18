import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AverageHeight {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<Integer>list = new ArrayList<>();
            int o = 0, e = 0;
            String [] inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                if (num % 2 == 0)
                    sb.append(num+" ");
                else
                    list.add(num);
            }
            for (int num : list) {
                sb.append(num+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
