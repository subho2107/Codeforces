import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(buffer.readLine());
            int num = 0;
            while (k > 0){
                num++;
                while (num % 3 == 0 || num %10 == 3)
                    num++;
                k--;
            }
            sb.append(num+"\n");
        }
        System.out.println(sb);
    }
}
