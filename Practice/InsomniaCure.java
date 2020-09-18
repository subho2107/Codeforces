import java.io.*;
import java.util.*;

public class InsomniaCure {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(buffer.readLine());
        int l = Integer.parseInt(buffer.readLine());
        int m = Integer.parseInt(buffer.readLine());
        int n = Integer.parseInt(buffer.readLine());
        int d = Integer.parseInt(buffer.readLine());
        int [] arr = {k, l, m, n};
        HashSet<Integer>effected = new HashSet<>();
        for (int fact : arr) {
            for (int dragon = fact; dragon <= d; dragon+=fact) {
                effected.add(dragon);
            }
        }
        System.out.println(effected.size());
    }
}
