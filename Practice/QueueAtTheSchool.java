import java.io.*;
import java.util.*;

public class QueueAtTheSchool {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), t = Integer.parseInt(inp[1]);
        char [] arrangement = buffer.readLine().toCharArray();
        for (int time = 0; time < t; time++)
        {
            for (int pos = 0; pos < n - 1; pos++) {
                if (arrangement[pos] == 'B' && arrangement[pos + 1] == 'G') {
                    arrangement[pos] = 'G';
                    arrangement[pos + 1] = 'B';
                    pos++;
                }
            }
        }
        for (char c : arrangement) {
            System.out.print(c);
        }
    }
}
