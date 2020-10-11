import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stairs {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long x = Long.parseLong(buffer.readLine());
            long pow = 1, cnt = 0, stairs = 1;
            while (true){
                x-=stairs*(stairs+1)/2;
                if (x < 0)
                    break;
                cnt++;
                pow*=2;
                stairs+=pow;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
