import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringEquality {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            char[] a = buffer.readLine().toCharArray();
            char [] b = buffer.readLine().toCharArray();
            int [] freqA = new int[26], freqB = new int[26];
            for (char c : a) {
                freqA[c-'a']++;
            }
            for (char c : b) {
                freqB[c-'a']++;
            }
            boolean check = true;
            for (int i = 0; i < 26; i++) {
                int val = Math.min(freqA[i], freqB[i]);
                freqA[i] -= val;
                freqB[i] -= val;
                if (freqA[i] !=0 && freqA[i]%k != 0){
                    check = false;
                    break;
                }
            }
           if (!check) {
               sb.append("NO\n");
               continue;
           }
           int [] kLengthSubs = new int[26];

            for (int i = 0; i < 26; i++) {
                if (freqA[i]%k != 0){
                    check = false;
                    break;
                }
                kLengthSubs[i] = freqA[i]/k;
            }
            if (!check){
                sb.append("NO\n");
                continue;
            }
            for (int i = 0; i < 26; i++) {
                if (freqB[i] != 0){
                    check = false;
                    break;
                }
                if (freqA[i] == 0)continue;
                for (int j = i+1; j < 26; j++) {
                    if (freqB[j]==0)continue;
                    int times = freqB[j]/k;
                    int val = Math.min(times, kLengthSubs[i]);
                    kLengthSubs[i]-=val;
                    freqB[j] -= val*k;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
