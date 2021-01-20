import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PuzzleFromTheFuture {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] b= buffer.readLine().toCharArray();
            char [] a = new char[n];
            a[0] = '1';
            for (int i = 1; i < n; i++) {
                int sum = Character.getNumericValue(a[i-1])+Character.getNumericValue(b[i-1]);
                int curr = Character.getNumericValue(b[i])+1;
                if (curr == sum)
                    a[i] = '0';
                else
                    a[i] = '1';
            }
            for (char c : a) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
