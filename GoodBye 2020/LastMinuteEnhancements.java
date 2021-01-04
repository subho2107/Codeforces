import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LastMinuteEnhancements {
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
            int i = n-1;
            for (; i >= 0; i--) {
                if (arr[i] == arr[n-1])
                    arr[i]++;
                else
                    break;
            }
            for(;i >= 0; i--){
                int dup = arr[i];
                if (arr[i]+1 != arr[i+1])
                    arr[i]++;
                i--;
                while (i >= 0 && arr[i] == dup)
                    i--;
                i++;
            }
//            System.out.println(Arrays.toString(arr));
            HashSet<Integer>hashSet = new HashSet<>();
            for (int nu : arr) {
                hashSet.add(nu);
            }
            sb.append(hashSet.size()+"\n");
        }
        System.out.println(sb);
    }
}
