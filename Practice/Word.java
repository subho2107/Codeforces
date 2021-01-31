import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Word {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String word = buffer.readLine();
            int small = 0, caps = 0;
            for (char ch : word.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z')
                    caps++;
                else
                    small++;
            }
            if (caps > small)
                word = word.toUpperCase();
            else
                word = word.toLowerCase();
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
