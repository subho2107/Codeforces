import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TMTDocument {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            ArrayList<Integer>arrayList = new ArrayList<>();
            int cntOfM = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'T')
                    arrayList.add(i);
                else if (s.charAt(i) == 'M')
                    cntOfM++;
            }
            if (cntOfM*2 != arrayList.size())
            {
                sb.append("NO\n");
                continue;
            }
            int k = arrayList.size()/2;
            boolean check = true;
            for (int i = 0, j = 0; i < n; i++) {
                if (s.charAt(i) == 'M'){
                    if (arrayList.get(j) >= i || arrayList.get(j+k) <= i){
                        check = false;
                        break;
                    }
                    j++;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}