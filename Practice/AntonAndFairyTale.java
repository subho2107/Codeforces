import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AntonAndFairyTale {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        long n = Long.parseLong(inp[0]), m = Long.parseLong(inp[1]);
        if (m >= n)
            System.out.println(n);
        else {
            long high = (long) 2e9, low = 0, diff = n-m, mid;
            while (low < high){
                mid = (high+low)/2;
                long temp = mid*(mid+1)/2;
                if (temp >= diff)
                    high = mid;
                else
                    low = mid+1;
            }
            System.out.println(m+low);
        }
    }
}
