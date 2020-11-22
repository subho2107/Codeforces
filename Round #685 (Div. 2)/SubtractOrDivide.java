import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubtractOrDivide {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int step = 0;
            while (n > 1){
                if (n % 2 == 0 && (n/2) != 1){
                    n/=(n/2);
                }
                else
                    n--;
                step++;
            }
            sb.append(step+"\n");
        }
        System.out.println(sb);
    }
}
