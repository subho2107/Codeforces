import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class FencePainting {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [] a = new int[n], b = new int[n], c = new int[m];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inp[i]);
            }
            ArrayList<Integer>[]colours = new ArrayList[n+1];
            for (int i = 0; i < n + 1; i++) {
                colours[i] = new ArrayList<>();
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(inp[i]);
                if (a[i] != b[i])
                    colours[b[i]].add(i);
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                c[i] = Integer.parseInt(inp[i]);
            }
            int lastFencePos = -1;
            int temp = colours[c[m-1]].size();
            if (temp > 0){
                lastFencePos = colours[c[m-1]].get(temp-1);
                colours[c[m-1]].remove(temp-1);
            }
            else {
                for (int i = 0; i < n; i++) {
                    if (b[i] == c[m-1])
                        lastFencePos = i;
                }
            }
            int [] ans = new int[m];
            ans[m-1] = lastFencePos;
            if (lastFencePos == -1)
                sb.append("NO\n");
            else {
                for (int i = 0; i < m - 1; i++) {
                    if (colours[c[i]].size() > 0){
                        temp = colours[c[i]].size();
                        ans[i] = colours[c[i]].get(temp-1);
                        colours[c[i]].remove(temp-1);
                    }
                    else
                        ans[i] = lastFencePos;
                }
                boolean check = true;
                for (ArrayList<Integer> colour : colours) {
                    if (colour.size() > 0)
                    {
                        check = false;
                        break;
                    }
                }
                if (!check)
                    sb.append("NO\n");
                else {
                    sb.append("YES\n");
                    for (int fence : ans) {
                        sb.append(fence+1).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
