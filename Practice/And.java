import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class And {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            int [] arr = new int[n];
            inp = buffer.readLine().split(" ");
            HashSet<Integer>set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                set.add(arr[i]);
            }
            if (set.size() < n)
                sb.append("0\n");
            else {
                boolean check = false;
                HashSet<Integer>set2 = new HashSet<>();
                for (int num : arr) {
                    set2.add(num^x);
                    if (set.contains(num^x))
                    {
                        check = true;
                        break;
                    }
                }
                if (check){
                    sb.append("1\n");
                    continue;
                }
                if (set2.size() < n)
                    sb.append("2\n");
                else
                    sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}
