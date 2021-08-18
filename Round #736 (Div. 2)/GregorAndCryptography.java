import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GregorAndCryptography {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            if (n % 2 == 0){
                sb.append(2+" "+n);
            }
            else
                sb.append(2+" "+(n-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
