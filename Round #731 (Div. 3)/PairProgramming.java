import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PairProgramming {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String temp = buffer.readLine();
            if (temp.length() == 0) {
                t++;
                continue;
            }
            String [] inp = temp.split(" ");
            int k = Integer.parseInt(inp[0]), n = Integer.parseInt(inp[1]), m = Integer.parseInt(inp[2]);
            inp =buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            inp =buffer.readLine().split(" ");
            int [] arr2 = new int[m];
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inp[i]);
            }
            int [] combined = new int[n+m];
            int a = 0, b = 0;
            boolean check = true;
            for (int i = 0; i < n + m; i++) {
                if (a < n && b < m && (arr[a] == 0 || arr2[b] == 0)){
                    if (arr[a] == 0){
                        combined[i] = arr[a];
                        a++;
                    }
                    else {
                        combined[i] = arr2[b];
                        b++;
                    }
                }
                else if (a < n && arr[a] <= k) {
                    combined[i] = arr[a];
                    a++;
                }
                else if (b < m &&  arr2[b] <= k) {
                    combined[i] = arr2[b];
                    b++;
                }
                else {
                    check = false;
                    break;
                }
                if (combined[i] == 0)
                    k++;
            }
            if (check){
                for (int i : combined) {
                    sb.append(i+" ");
                }
                sb.append("\n");
            }
            else
                sb.append(-1+"\n");
        }
        System.out.println(sb);
    }
}
