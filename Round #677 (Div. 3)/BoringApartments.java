import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BoringApartments {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int x = Integer.parseInt(buffer.readLine());
            long cnt = 0;
            for (int i = 1; i <= x%10 ; i++) {
                int num = 0;
                while (true){
                    num = num* 10 + i;
                    if (num > 10000)
                        break;
                    else if (i == x%10 && num > x)
                        break;
                    cnt+= Integer.toString(num).length();
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
