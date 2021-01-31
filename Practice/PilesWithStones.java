import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PilesWithStones {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] x = new int[n];
        long prevSum = 0, currSum = 0;
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(inp[i]);
            prevSum += x[i];
        }
        inp = buffer.readLine().split(" ");
        int [] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(inp[i]);
            currSum += y[i];
        }
        if (prevSum < currSum)
        System.out.println("NO");
        else
            System.out.println("YES");
    }
}
