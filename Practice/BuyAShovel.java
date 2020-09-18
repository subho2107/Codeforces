import java.io.*;
import java.util.*;

public class BuyAShovel {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int k = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
        int times = 0, price = 0;
        for (;price!=r;times++) {
            price += k;
            price%=10;
            if (price == 0){
                times++;
                break;
            }
        }
        System.out.println(times);
    }
}
