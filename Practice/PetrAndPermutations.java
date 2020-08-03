import java.io.*;
import java.util.*;

public class PetrAndPermutations {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] valueArr = new int[n];
        int [] indexArr = new int[n+1];
        for (int pos = 0; pos < n; pos++) {
            valueArr[pos] = pos+1;
            indexArr[pos+1] = pos;
        }
        int inversions = 0;
        for (int pos = 0; pos < n; pos++) {
            int num = Integer.parseInt(inp[pos]);
            if (valueArr[pos]!=num){
                int i = indexArr[num];
                valueArr[i] = valueArr[i]^ valueArr[pos]^(valueArr[pos]=valueArr[i]);
                indexArr[num] = pos;
                indexArr[valueArr[i]] = i;
                inversions++;
            }
        }
        inversions = 3*n-inversions;
        if (inversions%2==0)
            System.out.println("Petr");
        else
            System.out.println("Um_nik");
    }
}
