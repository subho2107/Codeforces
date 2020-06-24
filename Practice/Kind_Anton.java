import java.io.*;
import java.util.*;

public class Kind_Anton {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] a = buffer.readLine().split(" ");
            String[] b = buffer.readLine().split(" ");
            int [] ai = new int [n];
            int [] bi = new int[n];
            for (int pos = 0; pos < n;pos++) {
                ai[pos] = Integer.parseInt(a[pos]);
                bi[pos] = Integer.parseInt(b[pos]);
            }
            boolean [] posPres = new boolean[n];
            boolean [] negPres = new boolean[n];
            boolean checkPos = false, checkNeg = false;
            for (int pos = 0; pos < n; pos++) {
                posPres[pos] = checkPos;
                negPres[pos] = checkNeg;
                if (ai[pos]<0) checkNeg = true;
                if (ai[pos]>0)checkPos = true;

            }
            boolean possible = true;
            for (int pos = n-1; pos >= 0; pos--) {
                if (ai[pos]<bi[pos] && !posPres[pos]) {
                    possible = false;
                    break;
                }
                else  if (ai[pos]>bi[pos] && !negPres[pos])
                {
                    possible = false;
                    break;
                }
            }
            if (possible)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
