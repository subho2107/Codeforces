import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            long w = Long.parseLong(inp[1]);
            inp = buffer.readLine().split(" ");
            Integer [][] arr = new Integer[n][2];
            int pos = -1;
            long half = (long) Math.ceil(w/2.0);
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(inp[i]);
                arr[i][1] = i;
                if (arr[i][0] >= half && arr[i][0] <= w){
                    pos = i;
                    break;
                }
            }
            if (pos != -1){
                sb.append("1\n");
                sb.append(pos+1).append("\n");
                continue;
            }
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
            long sum = 0;
            ArrayList<Integer>positions = new ArrayList<>();
            for (Integer[] integers : arr) {
                if (sum + integers[0] > w)
                    break;
                sum += integers[0];
                positions.add(integers[1]+1);
                if(sum >= half && sum <= w)
                    break;
            }
            if (sum >= half && sum <= w && positions.size() > 0)
            {
                sb.append(positions.size() + "\n");
                for (Integer position : positions) {
                    sb.append(position + " ");
                }
            }
            else
                sb.append("-1");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
