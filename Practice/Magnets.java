import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Magnets {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String magnetPos = buffer.readLine();
            arr[i] = magnetPos;
        }
        int cnt = 0;
        for (int i = 0; i < n-1; i++) {
            if (!arr[i].equals(arr[i+1]))
                cnt++;
        }
        cnt++;
        System.out.println(cnt);
    }
}
