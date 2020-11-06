import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinimalHeightTree {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            ArrayList<Integer>arrayList = new ArrayList<>();
            int cnt = 0;
            arrayList.add(1);
            for (int i = 1; i < n - 1; i++) {
                cnt++;
                if (arr[i] > arr[i+1]){
                    arrayList.add(cnt);
                    cnt = 0;
                }
            }
            arrayList.add(cnt+1);
//            System.out.println(arrayList.toString());
            int height = 0;
            int prevLevelNodes = arrayList.get(0), currLevelNodes = 0;
            for (int i = 1; i < arrayList.size(); i++) {
                int last = i+prevLevelNodes;
                currLevelNodes = 0;
                for (;i<last && i < arrayList.size();i++)
                    currLevelNodes += arrayList.get(i);
                height++;
                prevLevelNodes = currLevelNodes;
                i--;
            }
            sb.append(height+"\n");
        }
        System.out.println(sb);
    }
}
