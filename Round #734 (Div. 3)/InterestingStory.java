import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class InterestingStory {
    public static boolean check(int[]totFreq, int totChars){
        for (int i : totFreq) {
            if (totChars-i < i)
                return true;
        }
        return false;
    }
    public static int getWords(ArrayList<int[]>list, char finalMaxChar, int n, int[] totFreq, int totChars){
        list.sort((o1, o2) -> o1[finalMaxChar -'a'] - o2[finalMaxChar-'a']);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                totFreq[j]-=list.get(i)[j];
            }
            if (check(totFreq, totChars))
                break;
            n--;
        }
        return n;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<int[]>list = new ArrayList<>();
            int [] totFreq = new int[5];
            int totChars = 0;
            for (int i = 0; i < n; i++) {
                String s = buffer.readLine();
                int [] freq = new int[5];
                for (char ch : s.toCharArray()) {
                    freq[ch - 'a']++;
                    totFreq[ch-'a']++;
                    totChars++;
                }
                list.add(freq);
            }
            int ans = 0;
            for (char i = 'a'; i <= 'e'; i++) {
                ans = Math.max(ans, getWords(list, i, n, Arrays.copyOf(totFreq, 5), totChars));
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
