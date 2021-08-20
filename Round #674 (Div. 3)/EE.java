import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EE {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            long n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long r = Integer.parseInt(inp[0]), s = Integer.parseInt(inp[1]), p = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            long r2 = Integer.parseInt(inp[0]), s2 = Integer.parseInt(inp[1]), p2 = Integer.parseInt(inp[2]);
            long ansMax = Math.min(r, s2)+Math.min(p, r2)+Math.min(s,p2);
//            long dups=s, dupr=r,dupp=p,dups2=s2,dupr2=r2,dupp2=p2;
            long ansMin = n-(Math.min(r, r2)+Math.min(p,p2)+Math.min(s,s2));
            long a = Math.min(r, r2), b = Math.min(p,p2), c = Math.min(s,s2);
            r-=a;r2-=a;
            p-=b;p2-=b;
            s-=c;s2-=c;
            ansMin-=(Math.min(s,r2)+Math.min(r, p2)+Math.min(p, s2));
//            long ansMin2 = n-(Math.min(dupp,dupp2)+Math.min(dupr,dupr2)+Math.min(dups,dups2));
//            dups-=Math.min(dups, dups2);dups2-=Math.min(dups, dupr2);
//            dupr-=Math.min(dupr,dupr2);dupr2-=Math.min(dupr,dupp2);
//            dupp-=Math.min(dupp,dups2);dupp2-=Math.min(dupp,dups2);
//            ansMin2-=(Math.min(dups, dupr2)+Math.min(dupr,dupp2)+Math.min(dupp,dups2));
//            ansMin = Math.min(ansMin, ansMin2);
            sb.append(ansMin+" "+ansMax+"\n");
        }
        System.out.println(sb);
    }
}
