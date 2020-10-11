import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DigitGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(buffer.readLine().trim());
            String num = buffer.readLine().trim();
            int[] arr = new int[n + 1];
            for (int pos = 1; pos <= n; pos++) {
                arr[pos] = Character.getNumericValue(num.charAt(pos-1));
            }
            boolean oddPres = false, evenPres = false;
            for (int pos = 1; pos <= n; pos++) {
                if (pos % 2 == 1 && arr[pos] % 2 == 1)
                    oddPres = true;
                else if (pos % 2 == 0 && arr[pos] % 2 == 0)
                    evenPres = true;
            }
//            System.out.println("a");
            if (n % 2 == 0) {
                if (evenPres)
                    sb.append("2");
                else
                    sb.append("1");
            } else {
                if (oddPres)
                    sb.append("1");
                else
                    sb.append("2");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}