import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IsItRated2 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if (buffer.readLine() == null)
                break;
            System.out.println("NO");
            System.out.flush();
        }
        System.out.println("");
    }
}
