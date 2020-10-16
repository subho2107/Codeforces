import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CarrotCakes {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), t = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]), d = Integer.parseInt(inp[3]);
        for (int time = 0; time <= d; time+=t)
            n-=k;
        if (n>0)
            System.out.println("YES\n");
        else
            System.out.println("NO\n");
    }
}
