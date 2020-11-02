import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class YetAnotherBookshelf {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int cnt = 0;
            ArrayList<int[]> arrayList = new ArrayList<>();
            int[] temp = new int[2];
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1 && (i == 0 || arr[i - 1] == 0)) {
                    temp = new int[2];
                    temp[0] = i;
                }
                if (arr[i] == 1 && (i == n - 1 || arr[i + 1] == 0)) {
                    temp[1] = i;
                    arrayList.add(temp);
                }
            }
            if (arrayList.size() == 1) {
                sb.append(0 + "\n");
                continue;
            }
            for (int i = 0; i < arrayList.size() - 1; i++) {
               cnt += arrayList.get(i+1)[0] - arrayList.get(i)[1] - 1;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
