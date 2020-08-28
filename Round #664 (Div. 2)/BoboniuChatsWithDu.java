import javax.naming.InsufficientResourcesException;
import java.io.*;
import java.util.*;

public class BoboniuChatsWithDu {
    public static void reverseAndAdd(ArrayList<Long> arrayList) {
        arrayList.sort(Collections.reverseOrder());
        for (int pos = 1; pos < arrayList.size(); pos++) {
            arrayList.set(pos, arrayList.get(pos) + arrayList.get(pos - 1));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), d = Integer.parseInt(inp[1]), m = Integer.parseInt(inp[2]);
        inp = buffer.readLine().split(" ");
        int[] arr = new int[n];
        ArrayList<Long> lessThanEqual = new ArrayList<>();
        ArrayList<Long> greaterThan = new ArrayList<>();
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
            if (arr[pos] <= m)
                lessThanEqual.add((long) arr[pos]);
            else
                greaterThan.add((long) arr[pos]);
        }
        if (greaterThan.size() == 0) {
            long sum = 0;
            for (Long num : lessThanEqual) {
                sum += num;
            }
            System.out.println(sum);
        } else {
            reverseAndAdd(lessThanEqual);
            reverseAndAdd(greaterThan);
            lessThanEqual.add(0, 0L);
            long temp = lessThanEqual.get(lessThanEqual.size()-1);
            for (int pos = 0; pos < n; pos++) {
                lessThanEqual.add(temp);
            }
            greaterThan.add(0, 0L);
            long sum = 0;
            for (int x = (greaterThan.size()+d)/(d+1); x < greaterThan.size(); x++) {
                if ((int) (n - ((long) (x - 1) * (d + 1) + 1))<lessThanEqual.size())
                if ((long) (x - 1) * (d + 1) + 1 <= n) {
                    sum = Math.max(sum, greaterThan.get(x) + lessThanEqual.get((int) (n - ((long) (x - 1) * (d + 1) + 1))));
                }
            }
            System.out.println(sum);
        }
    }
}

