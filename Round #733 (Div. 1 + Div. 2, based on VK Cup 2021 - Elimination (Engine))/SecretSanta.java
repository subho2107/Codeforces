import java.io.*;
import java.util.*;

public class SecretSanta {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n+1], dup = new int[n+1], inDegree = new int[n+1];
            int k = 0;
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(inp[i-1]);
                dup[i] = arr[i];
                if (inDegree[arr[i]] == 1)
                    arr[i] = -1;
                else {
                    inDegree[arr[i]]++;
                    k++;
                }
            }
            ArrayList<int[]>startAndEndOfPaths = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0){
                    int last = i;
                    while (arr[last] != -1)
                        last = arr[last];
                    startAndEndOfPaths.add(new int[]{i, last});
                }
            }
            int size = startAndEndOfPaths.size();
            if (size == 1 && startAndEndOfPaths.get(0)[0] == startAndEndOfPaths.get(0)[1]){
                int temp = startAndEndOfPaths.get(0)[0];
                int pos = dup[temp], pos2 = -1;
                for (int i = 1; i <= n; i++) {
                    if (arr[i] == pos){
                        pos2 = i;
                        break;
                    }
                }
                arr[pos2] = temp;
                arr[temp] = pos;
            }
            else
            {
                for (int i = 0; i < size; i++) {
                    int from = startAndEndOfPaths.get(i)[1], to = startAndEndOfPaths.get((i + 1) % size)[0];
                    arr[from] = to;
                }
            }
            sb.append(k+"\n");
            for (int i = 1; i <= n; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
