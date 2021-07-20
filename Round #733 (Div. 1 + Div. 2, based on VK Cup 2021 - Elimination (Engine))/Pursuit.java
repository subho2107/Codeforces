import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pursuit {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] myPoints = new int[n];
            String [] inp = buffer.readLine().split(" ");
            int roundConsidered = n - n/4;
            for (int i = 0; i < n; i++) {
                myPoints[i] = Integer.parseInt(inp[i]);
            }
            int [] herPoints = new int[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                herPoints[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(myPoints);
            Arrays.sort(herPoints);
            int myScore = 0, herScore = 0;
            for (int i = n-1; i >= n-roundConsidered; i--) {
                myScore += myPoints[i];
                herScore += herPoints[i];
            }
            int diff = herScore-myScore;
            if (diff < 0) {
                sb.append(0 + "\n");
                continue;
            }
            int cnt = 0, dup = n;
            int i = n-roundConsidered, j = n-roundConsidered-1;
            while (myScore < herScore){
                n++;
                if (n % 4 != 0){
                    myScore += 100;
                    if (j >= 0)
                    herScore += herPoints[j--];
                }
                else {
                    if (i < dup && myPoints[i] < 100)
                        myScore += 100 - myPoints[i++];
                }
                cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
