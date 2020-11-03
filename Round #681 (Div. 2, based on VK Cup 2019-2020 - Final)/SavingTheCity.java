import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SavingTheCity {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            String city = buffer.readLine();
            ArrayList<int[]> partition = new ArrayList<>();
            for (int i = 0; i < city.length(); i++) {
                if(city.charAt(i) == '0')
                    continue;
                int []arr = {i,0};
                int cnt = 0,j;
                for (j = i; j < city.length(); j++) {
                    if (city.charAt(j) == '0') {
                        j++;
                        break;
                    }
                    cnt++;
                }
                arr[1] = cnt;
                i = j-1;
                partition.add(arr);
            }
            if (partition.size() == 0){
                sb.append(0+"\n");
                continue;
            }
//            for (int[] ints : partition) {
//                sb.append(Arrays.toString(ints)+" ");
//            }
            long cost = a;
            for (int i = 1; i < partition.size(); i++) {
                int [] arr2 = partition.get(i), arr = partition.get(i-1);
                cost += Math.min(a, (long)(arr2[0]-(arr[0]+arr[1]))*b);
            }
            sb.append(cost+"\n");
        }
        System.out.println(sb);
    }
}
