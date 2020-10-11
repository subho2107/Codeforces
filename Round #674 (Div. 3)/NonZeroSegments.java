import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class NonZeroSegments {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long [] arr = new long[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            HashSet<Long>prevSum = new HashSet<>();
            long cnt = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum+=arr[i];
                if (prevSum.contains(sum)||sum==0){
                    cnt++;
                    sum=arr[i];
                    prevSum.clear();
                }
                prevSum.add(sum);
            }
            sb.append(cnt+"\n");

        }
        System.out.println(sb);
    }
}
