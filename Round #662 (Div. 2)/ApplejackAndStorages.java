import java.io.*;
import java.util.*;

public class ApplejackAndStorages {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        HashMap<Integer, Integer>frequency = new HashMap<>();
        HashSet<Integer>freq2 = new HashSet<>(), fre4 = new HashSet<>();
        for (int pos = 0; pos < n; pos++) {
            int num = Integer.parseInt(inp[pos]);
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
            if (frequency.get(num)==2)
                freq2.add(num);
            if (frequency.get(num)==4){
                fre4.add(num);
                freq2.remove(num);
            }
        }

        int q = Integer.parseInt(buffer.readLine());
        while (q-- > 0) {
            String[] s = buffer.readLine().split(" ");
            int num = Integer.parseInt(s[1]);
            if (s[0].equals("+"))
                frequency.put(num, frequency.getOrDefault(num, 0)+1);
            else {
                frequency.put(num, frequency.get(num) - 1);
                if (frequency.get(num) == 1)freq2.remove(num);
            }
            if (frequency.get(num)==0)frequency.remove(num);
            else
            {
                if (frequency.get(num) == 2) freq2.add(num);
                if (frequency.get(num) == 4) {
                    freq2.remove(num);
                    fre4.add(num);
                }
                if (frequency.get(num) == 3) {
                    fre4.remove(num);
                    freq2.add(num);
                }
            }
            boolean check = false;
            if (fre4.size() >= 2)
                check = true;
            else if (fre4.size() == 1) {
                int currFreq = frequency.get(fre4.iterator().next());
                if (currFreq >= 8)
                    check = true;
                else if (currFreq >= 6 && freq2.size() >= 1)
                    check = true;
                else if (freq2.size()>=2)
                    check = true;
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
