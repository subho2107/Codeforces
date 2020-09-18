import java.io.*;
import java.util.*;

public class AntonAndLetters {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        char [] s = buffer.readLine().toCharArray();
        HashSet<Character>set = new HashSet<>();
        for (char c : s) {
            if (c>='a' && c<= 'z')
                set.add(c);
        }
        System.out.println(set.size());
    }
}
