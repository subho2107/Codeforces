import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class TheDeliveryDilemma {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [][] arr = new int[n][2];
            long ans = 0;
            long pickupVal = 0, deliveryMax = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i][1] = Integer.parseInt(inp[i]);
                pickupVal += arr[i][1];
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0])
                        return o1[0] - o2[0];
                    else
                        return o1[1] - o2[1];
                }
            });
            ans = pickupVal;
            for (int i = 0; i < n; i++) {
                pickupVal -= arr[i][1];
               ans = Math.min(ans, Math.max(arr[i][0], pickupVal));
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
