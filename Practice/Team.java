import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        int cnt = 0;
        while (n-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]);
            int temp = 0;
            if (a == 1)
                temp++;
            if(b == 1)
                temp++;
            if (c == 1)
                temp++;
            if (temp >= 2)
                cnt++;
        }
        System.out.println(cnt);
    }
}
