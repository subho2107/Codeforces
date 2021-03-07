import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class CardDeck {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp=  buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            TreeSet<Integer> hashSet = new TreeSet<>(Collections.reverseOrder());
            for (int i = 1; i <=n; i++) {
                hashSet.add(i);
            }
            int i = n-1;
            ArrayList<Integer>arrayList = new ArrayList<>();
            while (!hashSet.isEmpty()){
                int num = hashSet.iterator().next();
                while (i > 0 && arr[i] != num){
                    hashSet.remove(arr[i]);
                    i--;
                }
                arrayList.add(i);
                i--;
                hashSet.remove(num);
            }
            i = arrayList.get(0);
            for (int j = i; j < n; j++) {
                sb.append(arr[j]+" ");
            }
            for (int j = 1; j < arrayList.size(); j++) {
                for (int k = arrayList.get(j); k < arrayList.get(j - 1); k++) {
                    sb.append(arr[k] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
