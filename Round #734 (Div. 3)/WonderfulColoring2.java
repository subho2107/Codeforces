import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class WonderfulColoring2 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k  = Integer.parseInt(inp[1]);
            int [] freq = new int[200001];
            int [] arr = new int[n];
            inp = buffer.readLine().split(" ");
            HashMap<Integer, ArrayList<Integer>>positions = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                positions.computeIfAbsent(arr[i], x->new ArrayList<>()).add(i);
                freq[arr[i]]++;
            }
            int [] ans = new int[n];
            int sum = 0;
            ArrayList<Integer> lessThanK = new ArrayList<>();
            for (int i : positions.keySet()) {
                if (freq[i] >= k)
                {
                    int colour = 1;
                    ArrayList<Integer>currPositions = positions.get(i);
                    for (int j = 0; j < k; j++) {
                        ans[currPositions.get(j)] = colour++;
                    }
                }
                else {
                    lessThanK.add(i);
                    sum+=freq[i];
                }
            }
            sum/=k;
            int colour = 1;
            for (int num : lessThanK) {
                for (int i : positions.get(num)) {
                    ans[i] = colour++;
                    if (colour == k+1) {
                        colour = 1;
                        sum--;
                    }
                    if (sum == 0)
                        break;
                }
                if (sum == 0)
                    break;
            }
            for (int an : ans) {
                sb.append(an+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
