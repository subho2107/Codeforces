import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BoyOrGirl {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String s = buffer.readLine();
            HashSet<Character>hashSet = new HashSet<>();
            for(char ch : s.toCharArray())
                hashSet.add(ch);
            if (hashSet.size() % 2 == 1)
                sb.append("IGNORE HIM!\n");
            else
                sb.append("CHAT WITH HER!\n");
        }
        System.out.println(sb);
    }
}
