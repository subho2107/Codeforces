import java.io.*;
import java.util.*;

public class ColoredRectangles {
    public static  boolean checkEqual(int a, int b, int c, int d){
        if (a==c && b == d)
            return true;
        if (a==d&&b==c)
            return true;
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int r = Integer.parseInt(inp[0]), g = Integer.parseInt(inp[1]), b = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            ArrayList<Integer>redPairs = new ArrayList<>();
            for (int pos = 0; pos < r; pos++) {
                redPairs.add(Integer.parseInt(inp[pos]));
            }
            inp = buffer.readLine().split(" ");
            ArrayList<Integer>greenPairs = new ArrayList<>();
            for (int pos = 0; pos < g; pos++) {
                greenPairs.add(Integer.parseInt(inp[pos]));
            }
            ArrayList<Integer>bluePairs = new ArrayList<>();
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < b; pos++) {
                bluePairs.add(Integer.parseInt(inp[pos]));
            }
            Collections.sort(redPairs);Collections.sort(bluePairs);Collections.sort(greenPairs);
            long totArea = 0;
            while(true){
                int cnt = 0;
                if (redPairs.size()>0)cnt++;
                if (bluePairs.size()>0)cnt++;
                if (greenPairs.size()>0)cnt++;
                if (cnt<2)break;
                if (cnt==3){
                    int sr, sg, sbl;
                    sr = redPairs.get(redPairs.size()-1);
                    sg = greenPairs.get(greenPairs.size()-1);
                    sbl = bluePairs.get(bluePairs.size()-1);
                    int [] temp = {sr, sg, sbl};
                    Arrays.sort(temp);
                    totArea+= temp[2]* temp[1];
                    if (checkEqual(sr, sg, temp[2], temp[1])){
                        redPairs.remove(redPairs.size()-1);
                        greenPairs.remove(greenPairs.size()-1);
                    }
                    else if (checkEqual(sg, sbl, temp[2], temp[1])){
                        greenPairs.remove(greenPairs.size()-1);
                        bluePairs.remove(bluePairs.size()-1);
                    }
                    else{
                        redPairs.remove(redPairs.size()-1);
                        bluePairs.remove(bluePairs.size()-1);
                    }
                }
                else {
                    if (redPairs.size()==0){
                        totArea += bluePairs.get(bluePairs.size()-1)*greenPairs.get(greenPairs.size()-1);
                        greenPairs.remove(greenPairs.size()-1);
                        bluePairs.remove(bluePairs.size()-1);
                    }
                    else if (bluePairs.size()==0){
                        totArea+= greenPairs.get(greenPairs.size()-1)*redPairs.get(redPairs.size()-1);
                        redPairs.remove(redPairs.size()-1);
                        greenPairs.remove(greenPairs.size()-1);
                    }
                    else {
                        totArea += redPairs.get(redPairs.size()-1)*bluePairs.get(bluePairs.size()-1);
                        redPairs.remove(redPairs.size()-1);
                        bluePairs.remove(bluePairs.size()-1);
                    }
                }
            }
            if (totArea<0)
                throw new Exception("fd");
            sb.append(totArea+"\n");
        }
        System.out.println(sb);
    }
}
