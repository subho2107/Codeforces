import java.io.*;
import java.util.*;

public class RPGProtagonist {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int my = Integer.parseInt(inp[0]), follower = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int sword = Integer.parseInt(inp[0]), axe = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int swordWeight = Integer.parseInt(inp[0]), axeWeight = Integer.parseInt(inp[1]);
            if (swordWeight > axeWeight) {
                sword = sword ^ axe ^ (axe = sword);
                swordWeight = axeWeight ^ swordWeight ^ (axeWeight = swordWeight);
            }
            int ans = 0;
            for (int mySword = 0; mySword < sword + 1; mySword++) {
                int tempCap = my, tempCap2 = follower, currTotWeapons = 0;
                int tempSword = sword, tempAxe = axe;
                int swordTakenByMe = Math.min(mySword, tempCap / swordWeight), axeTakenByMe;
                tempCap -= swordTakenByMe * swordWeight;
                axeTakenByMe = Math.min(tempAxe, tempCap / axeWeight);
                currTotWeapons += swordTakenByMe + axeTakenByMe;
                tempSword -= swordTakenByMe;
                tempAxe -= axeTakenByMe;

                swordTakenByMe = Math.min(tempSword, tempCap2 / swordWeight);
                tempCap2 -= swordTakenByMe * swordWeight;
                axeTakenByMe = Math.min(tempAxe, tempCap2 / axeWeight);
                currTotWeapons += swordTakenByMe + axeTakenByMe;
                ans = Math.max(ans, currTotWeapons);
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}