import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StrangeFunctions {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            sb.append(s.length()+"\n");
        }
        System.out.println(sb);
    }
}
