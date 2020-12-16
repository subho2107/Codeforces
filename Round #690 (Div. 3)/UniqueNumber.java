import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UniqueNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-->0){
            int x = Integer.parseInt(buffer.readLine());
            if (x > 45) {
                sb.append("-1\n");
                continue;
            }
            int num = 0;
            int sum = 0, dig = 9;
            while (sum <= x){
                if (x-sum <= dig)
                {
                    int temp = x-sum;
                    sum+=temp;
                    num = num*10+temp;
                    break;
                }
                sum += dig;
                num = num * 10 + dig;
                dig--;
            }
            int dup = 0;
            while (num != 0){
                dup = dup*10+ num % 10;
                num/=10;
            }
            sb.append(dup+"\n");

        }
        System.out.println(sb);
    }
}
