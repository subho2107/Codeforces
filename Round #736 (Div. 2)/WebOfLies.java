import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebOfLies {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
        int [] friends = new int[n];
        int noFriends = 0;
        for (int i = 0; i < m; i++) {
            inp = buffer.readLine().split(" ");
            int u = Integer.parseInt(inp[0])-1, v = Integer.parseInt(inp[1])-1;
            if (u > v)
                u = u^v^(v = u);
            friends[u]++;
        }
        for (int i = 0; i < n; i++) {
            if (friends[i] == 0)
                noFriends++;
        }
        int q = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < q; i++) {
            inp = buffer.readLine().split(" ");
            int type = Integer.parseInt(inp[0]);
            if (type != 3){
                int u = Integer.parseInt(inp[1])-1, v = Integer.parseInt(inp[2])-1;
                if (u > v)
                    u = u^v^(v = u);
                if (type == 1) {
                    if (friends[u] == 0)
                        noFriends--;
                    friends[u]++;
                }
                else {
                    if (friends[u] == 1)
                        noFriends++;
                    friends[u]--;
                }
            }
            else {
                sb.append(noFriends+"\n");
            }
        }
        System.out.println(sb);
    }
}
