import java.io.*;
import java.util.*;

public class Movebrackets {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int len = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            ArrayList<Character>temp = new ArrayList<Character>();
            for (int pos = 0; pos < len; pos++) {
                temp.add(s.charAt(pos));
                if (temp.size()>=2)
                {
                    if (temp.get(temp.size()-1)==')' && temp.get(temp.size()-2)=='(')
                    {
                        temp.remove(temp.size()-1);
                        temp.remove(temp.size()-1);
                    }
                }
            }
            int ans = temp.size()/2;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
