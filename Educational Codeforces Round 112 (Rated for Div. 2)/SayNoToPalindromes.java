import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SayNoToPalindromes {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            List<String> list = new ArrayList<>();
            list.add("abc");
            list.add("acb");
            list.add("bca");
            list.add("bac");
            list.add("cab");
            list.add("cba");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            char [] arr = buffer.readLine().toCharArray();
            int [][] diff = new int[n][6];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 6; j++) {
                    diff[i][j] = arr[i] != list.get(j).charAt(i%3)?1:0;
                    if (i > 0)
                        diff[i][j] += diff[i-1][j];
                }
            }
            for (int i = 0; i < k; i++) {
                inp = buffer.readLine().split(" ");
                int l = Integer.parseInt(inp[0])-2, r = Integer.parseInt(inp[1])-1;
                if (l == r){
                    sb.append(0+"\n");
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int j = 0; j < 6; j++) {
                    if (l >= 0)
                    ans = Math.min(ans, diff[r][j]-diff[l][j]);
                    else
                        ans = Math.min(ans, diff[r][j]);
                }
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb);
    }
}
