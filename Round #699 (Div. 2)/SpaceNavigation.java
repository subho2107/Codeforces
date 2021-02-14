import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpaceNavigation {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String []  inp = buffer.readLine().split(" ");
            int px = Integer.parseInt(inp[0]), py = Integer.parseInt(inp[1]);
            String s = buffer.readLine();
            int l = 0, r = 0, u = 0, d = 0;
            for (char ch : s.toCharArray()) {
                switch (ch){
                    case 'L':
                        l++;
                        break;
                    case 'R':
                        r++;
                        break;
                    case 'D':
                        d++;
                        break;
                    case 'U':
                        u++;
                        break;
                }
            }
            boolean a = false, b = false;
//            sb.append(l+" "+r+" "+d+" "+u).append("\n");
            if ((px > 0 && r >= px) || (px < 0 && l >= -px)||px==0)
                a = true;
            if ((py > 0 && u >= py) || (py < 0 && d >= -py)||py == 0)
                b = true;
            if (a && b)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
