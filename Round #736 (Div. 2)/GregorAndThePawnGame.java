import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GregorAndThePawnGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] row1 = new int[n], rowN = new int[n];
            char [] arr = buffer.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                row1[i] = Character.getNumericValue(arr[i]);
            }
            int ans = 0;
            arr = buffer.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                rowN[i] = Character.getNumericValue(arr[i]);
            }
            for (int i = 0; i < n; i++) {
                if (rowN[i] == 0)
                    continue;
                boolean checkLeft = i >= 1 && row1[i-1] == 1, checkRight = i < n-1 &&  row1[i+1] == 1;
                if (checkLeft){
                    ans++;
                    row1[i-1] = -1;
                    rowN[i] = 0;
                }
                else if (row1[i] == 0){
                    ans++;
                    row1[i] = -1;
                    rowN[i] = 0;
                }
                else if (checkRight){
                    ans++;
                    row1[i+1] = -1;
                    rowN[i] = 0;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
