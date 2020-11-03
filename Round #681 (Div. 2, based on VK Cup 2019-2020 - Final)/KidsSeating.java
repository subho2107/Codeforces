import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KidsSeating {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<Integer> arrayList = new ArrayList<>();
//            ((n/2)*2)<n?((n/2 + 1)*2):(n/2)*2
            for (int k = 1; k <= 3 * n; k++) {
                for (int i = k, j = 0;
                     i < 4 * n + 1 && j < n;
                     i++) {
                    boolean check = false;
                    for (Integer num : arrayList) {
                        if (i % num == 0 || gcd(num, i) == 1) {
                            check = true;
                            break;
                        }
                    }
                    if (check)
                        continue;
                    j++;
                    arrayList.add(i);
                }
                if (arrayList.size() == n)
                    break;
                arrayList.clear();
            }
//            sb.append(arrayList.size()+" ");
            for (Integer num : arrayList) {
                sb.append(num+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
