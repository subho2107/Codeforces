import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistrictsConnection {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            boolean check = true;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (i >= 1 && arr[i] != arr[i-1])
                    check = false;
            }
            if (check)
                sb.append("NO\n");
            else {
                sb.append("YES\n");
                int pos = -1;
                for (int i = 1; i < n; i++) {
                    if (arr[i] != arr[0]) {
                        sb.append(1 + " " + (i + 1) + "\n");
                        pos = i;
                    }
                }
                pos++;
                for (int i = 0; i < n; i++) {
                    if (i!=0 && arr[i] == arr[0]){
                        sb.append((i+1)+" "+pos+"\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
