import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SequenceTransformation {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" " );
            ArrayList<Integer>[]positions = new ArrayList[n+1];
            for (int i = 0; i < n + 1; i++) {
                positions[i] = new ArrayList<>();
            }
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                arr[i] = num;
                positions[num].add(i);
            }
            int cnt = Integer.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                if (positions[i].size() == 0)
                    continue;
                int tempPartitions = 0;
                if (positions[i].get(0) > 0)
                    tempPartitions++;
                for (int pos : positions[i]) {
                    if (pos + 1<= n-1 && arr[pos+1] != arr[pos])
                        tempPartitions++;
                }
                cnt = Math.min(cnt, tempPartitions);
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
