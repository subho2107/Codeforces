import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DMCA {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int num = Integer.parseInt(buffer.readLine());
            while (Integer.toString(num).length() != 1){
                int sum = 0;
                int dup = num;
                while (dup != 0){
                    sum += dup % 10;
                    dup /= 10;
                }
                num = sum;
            }
            System.out.println(num);
        }
        System.out.println(sb);
    }
}
