import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class TeamOlympiad {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        ArrayList<Integer>one = new ArrayList<>(), two = new ArrayList<>(), three = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int skill = Integer.parseInt(inp[i]);
            if (skill == 1)
                one.add(i+1);
            else if (skill == 2)
                two.add(i+1);
            else
                three.add(i+1);
        }
        int teams = Math.min(one.size(), Math.min(two.size(), three.size()));
        System.out.println(teams);
        if (teams!=0)
        {
            for (int i = 0; i < teams; i++) {
                sb.append(one.get(i) + " " + two.get(i) + " " + three.get(i) + "\n");
            }
        }
        System.out.println(sb);
    }
}
