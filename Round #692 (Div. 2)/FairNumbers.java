import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FairNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(buffer.readLine());
            for (long i = n; ; i++) {
                long dup = i;
                boolean check = true;
                while (dup != 0){
                    if (dup % 10 != 0 && i % (dup % 10) != 0){
                        check = false;
                        break;
                    }
                    dup /= 10;
                }
                if (check)
                {
                    sb.append(i+"\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
