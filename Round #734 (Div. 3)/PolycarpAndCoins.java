import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PolycarpAndCoins {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int parts = n/3;
            int a = parts*2;
            int b = n - a;
            if (b - parts == 2){
                b-=2;
                parts++;
            }
            sb.append(b+" "+parts+"\n");
        }
        System.out.println(sb);
    }
}
