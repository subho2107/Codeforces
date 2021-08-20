import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsequencePermutation {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] arr = buffer.readLine().toCharArray();
            char [] dup = new char[n];
            for (int i = 0; i < n; i++) {
                dup[i] = arr[i];
            }
            int cnt = 0;
            Arrays.sort(dup);
            for (int i = 0; i < n; i++) {
                if (dup[i] != arr[i])
                    cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}