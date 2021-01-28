import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class NezzarAndColorfulBalls {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            HashSet<Integer>hashSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                hashSet.add(i);
            }
            int cnt = 0;
            while (hashSet.size() != 0){
                cnt++;
                int pos = -1;
                for(int num : hashSet)
                {
                    pos = num;
                    break;
                }
                int prev = -1;
                for (int i = pos; i < n; i++) {
                    if (arr[i] > prev && hashSet.contains(i)){
                        hashSet.remove(i);
                        prev = arr[i];
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
