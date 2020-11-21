import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpecificTastesOfAndre {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            for (int i = 0; i < n; i++) {
                sb.append(1+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
