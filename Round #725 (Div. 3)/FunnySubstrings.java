import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FunnySubstrings {
    static class Variable{
        int len;
        long hahaCnt;
        String first, last;
        Variable(String s){
            first = s;
            last = s;
            len = s.length();
            hahaCnt = countHaha(s);
            trim();
        }
        void trim(){
            if (first.length() > 3)first = first.substring(0, 3);
            if (last.length() > 3)last = last.substring(last.length()-3);
        }
    }
    public static int countHaha(String s){
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith("haha", i))
                cnt++;
        }
        return cnt;
    }
    public static Variable concat(Variable a, Variable b){
        Variable c = new Variable("");
        c.len = a.len+b.len;
        c.first = a.first+b.first;
        c.last = a.last+b.last;
        c.hahaCnt = a.hahaCnt+b.hahaCnt;
        c.hahaCnt += countHaha(a.last+b.first);
        c.trim();
        return c;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            HashMap<String, Variable>map = new HashMap<>();
            int n = Integer.parseInt(buffer.readLine());
            String lastVar = "";
            for (int i = 0; i < n; i++) {
                String [] inp = buffer.readLine().split(" ");
                if (inp[1].equals(":=")){
                    String var = inp[0], val = inp[2];
                    map.put(var, new Variable(val));
                    lastVar = var;
                }
                else {
                    String var = inp[0], val1 = inp[2], val2 = inp[4];
                    lastVar = var;
                    if (!map.containsKey(var))
                        map.put(var, new Variable(""));
                    map.put(var,concat(map.get(val1),map.get(val2)));
                }
            }
            Variable temp = map.get(lastVar);
            sb.append(temp.hahaCnt).append("\n");
        }
        System.out.println(sb);
    }
}
