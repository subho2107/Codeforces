import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Minimax {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            int n = s.length();
            int [] freq = new int[26];
            char singleFreq = ' ';
            ArrayList<Character>uniques = new ArrayList<>();
            for (char ch : s.toCharArray()) {
                freq[ch-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i]==1)
                {
                    singleFreq = (char)('a'+i);
                    break;
                }
                if (freq[i] != 0)
                    uniques.add((char)(i+'a'));
            }
            if (singleFreq != ' '){
                sb.append(singleFreq);
                for (int i = 0; i < 26; i++) {
                    if (i == singleFreq-'a')
                        continue;
                    while (freq[i]-->0){
                        sb.append((char) ('a'+i));
                    }
                }
                sb.append("\n");
                continue;
            }
            if (uniques.size() >= 3){
                sb.append(uniques.get(0)+uniques.get(1));
                freq[uniques.get(0)-'a']--;freq[uniques.get(1)-'a']--;
                while (freq[uniques.get(0)-'a']-->0)
                    sb.append(uniques.get(0));
                sb.append(uniques.get(2));
                freq[uniques.get(2)-'a']--;
                for (Character ch : uniques) {
                    while (freq[ch-'a']-->0)
                        sb.append(ch);
                }
            }
            else if (uniques.size() == 2){
                char first = uniques.get(0), sec = uniques.get(1);
                sb.append(first);
                freq[first-'a']--;
                while (freq[first-'a'] > 0 || freq[sec-'a'] > 0){
                    if (freq[first-'a']-->0)
                        sb.append(first);
                    if (freq[sec-'a']-->0)
                        sb.append(sec);
                }
            }
            else
                sb.append(s);

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
