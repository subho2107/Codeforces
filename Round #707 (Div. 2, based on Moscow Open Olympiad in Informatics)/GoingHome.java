import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GoingHome {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            boolean check = false;
            HashMap<Integer, int []> map = new HashMap<>();
            for (int i = 0; i < Math.min(4000,n); i++) {
                for (int j = i+1; j < Math.min(4000,n); j++) {
                    int sum = arr[i]+arr[j];
                    if (map.containsKey(sum)){
                        int a = map.get(sum)[0], b = map.get(sum)[1];
                        if (a == i || a == j || b == i || b == j)
                            continue;
                        check = true;
                        sb.append("YES\n");
                        a++;b++;i++;j++;
                        sb.append(a+" "+b+" "+i+" "+j+"\n");
                        break;
                    }
                    map.put(sum, new int[]{i, j});
                }
                if (check)
                    break;
            }
            if (!check)
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
