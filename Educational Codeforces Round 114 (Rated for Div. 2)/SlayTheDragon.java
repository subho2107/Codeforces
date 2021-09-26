import java.io.*;
import java.util.*;

public class SlayTheDragon {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            Long [] strengthsOfHeroes = new Long[n];
            String [] inp = buffer.readLine().split(" ");
            long sumOfStrengths = 0;
            for (int i = 0; i < n; i++) {
                strengthsOfHeroes[i] = Long.parseLong(inp[i]);
                sumOfStrengths += strengthsOfHeroes[i];
            }
            Arrays.sort(strengthsOfHeroes);
            int m = Integer.parseInt(buffer.readLine());
            for (int i = 0; i < m; i++) {
                inp = buffer.readLine().split(" ");
                long x = Long.parseLong(inp[0]), y =Long.parseLong(inp[1]);
                long goldCoins = 0;
                if (x < strengthsOfHeroes[0])
                    goldCoins = Math.max(0, y - (sumOfStrengths-strengthsOfHeroes[0]));
                else if (x > strengthsOfHeroes[n-1])
                    goldCoins = x-strengthsOfHeroes[n-1]+Math.max(0, y-(sumOfStrengths-strengthsOfHeroes[n-1]));
                else {
                    int heroSent = Arrays.binarySearch(strengthsOfHeroes, x);
                    if (heroSent < 0)
                        heroSent = -(heroSent+1);
                    goldCoins = Math.max(0, y-(sumOfStrengths-strengthsOfHeroes[heroSent]));
                    if (heroSent - 1>= 0) {
                        heroSent--;
                        goldCoins = Math.min(goldCoins, Math.max(0, x-strengthsOfHeroes[heroSent])+Math.max(0, y-(sumOfStrengths-strengthsOfHeroes[heroSent])));

                    }
                }
                sb.append(goldCoins+"\n");
            }
        }
        System.out.println(sb);
    }
}
