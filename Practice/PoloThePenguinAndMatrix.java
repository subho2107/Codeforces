import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class PoloThePenguinAndMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), d = Integer.parseInt(inp[2]);
        boolean check = true;
        ArrayList<Integer>arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inp = buffer.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arrayList.add(Integer.parseInt(inp[j]));
            }
        }
        arrayList.sort(Comparator.comparingInt(o -> o));
        int num = arrayList.get(arrayList.size()/2);
//        for (int currNum : arrayList) {
//
//        }
        if (!check)
            System.out.println(-1);
//        else
//            System.out.println(max);
    }
}
