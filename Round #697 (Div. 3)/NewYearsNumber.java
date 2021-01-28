import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewYearsNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n= Integer.parseInt(buffer.readLine());
            int b = n % 2020;
            int aplusb = n/2020;
            int a = aplusb - b;
            if (a >= 0 && b >= 0 && 2020*a + 2021*b == n)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
