import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PetyaAndStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String a = buffer.readLine().toLowerCase();
            String b = buffer.readLine().toLowerCase();
            int diff = a.compareTo(b);
            if (diff == 0)
                sb.append(diff).append("\n");
            else if (diff < 0)
                sb.append("-1\n");
            else
                sb.append("1\n");
        }
        System.out.println(sb);
    }
}
