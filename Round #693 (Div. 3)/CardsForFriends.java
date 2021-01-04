import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CardsForFriends {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int w = Integer.parseInt(inp[0]), h = Integer.parseInt(inp[1]), n = Integer.parseInt(inp[2]);
            long cnt = 1;
            while (w > 0 && h > 0 && (w % 2 == 0 || h % 2 == 0) && cnt < n){
                if (w % 2 == 0)
                    w /= 2;
                else
                    h /= 2;
                cnt *= 2;
            }
            if (cnt >= n)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
