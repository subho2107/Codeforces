import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwentyFourGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        if (n <= 3)
            sb.append("NO\n");
        else if (n % 2 == 0){
            sb.append("YES\n");
            sb.append("1 * 2 = 2").append("\n");
            sb.append("2 * 3 = 6").append("\n");
            sb.append("6 * 4 = 24").append("\n");
            for (int i = 5; i < n; i+=2) {
                sb.append(i + 1).append(" - ").append(i).append(" = 1").append("\n");
                sb.append(24).append(" * 1 = 24").append("\n");
            }
        }
        else {
            sb.append("YES\n");
            sb.append("2 - 1 = 1").append("\n");
            sb.append("3 + 1 = 4").append("\n");
            sb.append("5 * 4 = 20").append("\n");
            sb.append("20 + 4 = 24").append("\n");
            for (int i = 6; i < n; i+=2) {
                sb.append(i + 1).append(" - ").append(i).append(" = 1").append("\n");
                sb.append(24).append(" * 1 = 24").append("\n");
            }
        }
        System.out.println(sb);
    }
}
