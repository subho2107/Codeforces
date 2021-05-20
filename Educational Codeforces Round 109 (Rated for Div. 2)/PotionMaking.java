import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PotionMaking {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(buffer.readLine());
            boolean check = false;
            for (int i = 1; i < 101; i++) {
                double magic = (k*i)/100.0;
                if ((int)magic == magic)
                {
                    sb.append(i+"\n");
                    check = true;
                    break;
                }
            }
            if (!check)
                sb.append("100\n");
        }
        System.out.println(sb);
    }
}
