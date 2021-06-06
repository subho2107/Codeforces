import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DilucAndKaeya {
    public static int gcd(int a , int b){
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] arr = buffer.readLine().toCharArray();
            int d = 0, k = 0;
            Map<Integer, Map<Integer, Integer>>ratio = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] == 'D')
                    d++;
                else
                    k++;
                int temp = gcd(d, k);
                int a = d/temp, b = k/temp;
                if (!ratio.containsKey(a))
                    ratio.put(a, new HashMap<>());
                ratio.get(a).put(b, ratio.get(a).getOrDefault(b, 0)+1);
                sb.append(ratio.get(a).get(b)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
