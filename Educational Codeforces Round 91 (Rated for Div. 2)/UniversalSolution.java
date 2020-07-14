import java.io.*;
import java.util.*;

public class UniversalSolution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String inp = buffer.readLine();
            StringBuilder ans = new StringBuilder();
            for (char ch :
                    inp.toCharArray()) {
                if (ch == 'R')
                    ans.append('P');
                else if (ch == 'P')
                    ans.append('S');
                else
                    ans.append('R');
            }
            HashMap<Character, Integer>hashMap = new HashMap<>();
            for (char ch :
                    ans.toString().toCharArray()) {
                hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
            }
            List<Map.Entry<Character, Integer>>list=new LinkedList<>(hashMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return -(o1.getValue()).compareTo(o2.getValue());
                }
            });

            char ch = 'a';
            for (Map.Entry<Character, Integer> aa :
                    list) {
                ch = aa.getKey();
                break;
            }
            for (int i = 0; i < ans.length() ; i++) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
