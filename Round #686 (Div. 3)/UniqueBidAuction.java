import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class UniqueBidAuction {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [][] arr = new int[n][2];
            HashMap<Integer, Integer>hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(inp[i]);
                arr[i][1] = i+1;
                hashMap.put(arr[i][0], hashMap.getOrDefault(arr[i][0], 0)+1);
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });int pos = -1;
            for (int[] ints : arr) {
                if (hashMap.get(ints[0]) == 1)
                {
                    pos = ints[1];
                    break;
                }
            }
            sb.append(pos+"\n");
        }
        System.out.println(sb);
    }
}
