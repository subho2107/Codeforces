import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PhoenixAndPuzzle {
    public static boolean perfectSquare(int n){
        int root = (int) Math.sqrt(n);
        long possN = (long) root *root;
        return possN == n;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int a = n/2, b = n/4, c = n/8;
            if ((n %2 == 0 && perfectSquare(a)) || (n % 4 == 0 && perfectSquare(b)) || (n % 8 == 0 && perfectSquare(c)))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
