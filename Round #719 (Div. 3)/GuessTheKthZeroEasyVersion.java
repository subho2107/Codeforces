import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GuessTheKthZeroEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int t = Integer.parseInt(inp[1]);
        while (t-- > 0) {
            int k = Integer.parseInt(buffer.readLine());
            if (k == -1)
                return;
            int low = 1, high = n;
            int mid = (low+high)/2;
            while (low <= high){
                mid = (low+high)/2;
                if (low == high)
                    break;
                System.out.println("? "+low+" "+mid);
                int sum = Integer.parseInt(buffer.readLine());
                System.out.flush();
                if (sum == -1)
                    return;
                if ((mid-low+1)-sum >= k)
                    high = mid;
                else {
                    low = mid + 1;
                    k -= (mid-low+1)-sum;
                }
            }
            System.out.println("! "+mid);
            System.out.flush();
        }
    }
}
