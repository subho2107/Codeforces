import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongJumps {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            String [] inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            long [] vals = new long[n];
//            HashSet<Integer>pos = new HashSet<>();
//            for (int i = 0; i < n; i++) {
//                pos.add(i);
//            }
//            while (!pos.isEmpty()){
//                int i = pos.iterator().next();
//                for (int j = i; j < n && pos.contains(j); j+=arr[i]) {
//                    vals[j] += arr[j];
//                    if (j + arr[j] < n && pos.contains(j + arr[i]))
//                        vals[j + arr[j]] += vals[j];
//                    pos.remove(j);
//                }
//            }
            for (int i = 0; i < n; i++) {
                vals[i] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                if (i + arr[i] < n)
                    vals[i + arr[i]] = Math.max(vals[i+arr[i]], vals[i] + arr[i+arr[i]]);
            }
//            System.out.println(Arrays.toString(vals));
            long maxVal = Integer.MIN_VALUE;
            for (long val : vals) {
                maxVal = Math.max(maxVal, val);
            }
            sb.append(maxVal+"\n");
        }
        System.out.println(sb);
    }
}
