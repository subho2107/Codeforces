import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ABPalindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
            int [] colour = new int[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                colour[i] = Integer.parseInt(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            int [] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = Integer.parseInt(inp[i]);
            }
            HashMap<Integer, ArrayList<Integer>>map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(colour[i]))
                    map.put(colour[i], new ArrayList<>());
                map.get(colour[i]).add(i+1);
            }
            for (int query : queries) {
                int index = Collections.min(map.get(query));
                sb.append(index+" ");
                for (ArrayList<Integer> value : map.values()) {
                    for (int i = 0; i < value.size(); i++) {
                        if (value.get(i) < index)
                            value.set(i, value.get(i)+1);
                        else if (value.get(i) == index)
                            value.set(i, 1);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
