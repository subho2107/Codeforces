import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StrangeList {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            ArrayList<int[]>arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                arrayList.add(new int[]{num, 1});
            }
            for (int i = 0;; i++) {
                int num = arrayList.get(i)[0], freq = arrayList.get(i)[1];
                if (num%x!=0)
                    break;
                arrayList.add(new int[]{num/x, freq*x});
            }
            long sum = 0;
            for (int[] arr : arrayList) {
                sum += (long) arr[0]*arr[1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
