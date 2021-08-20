import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class MetaboliteAnnotation {
    //this method was taken from https://www.geeksforgeeks.org/find-closest-number-array/
    public static int findClosest(double [][] arr, double target)
    {
        int n = arr.length;
        if (target <= arr[0][0])
            return 0;
        if (target >= arr[n - 1][0])
            return n-1;
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid][0] == target)
                return mid;
            if (target < arr[mid][0]) {
                if (mid > 0 && target > arr[mid - 1][0])
                    return getClosest(arr,mid - 1,
                            mid, target);
                j = mid;
            }
            else {
                if (mid < n-1 && target < arr[mid + 1][0])
                    return getClosest(arr, mid,
                            mid + 1, target);
                i = mid + 1;
            }
        }
        return mid;
    }
    public static int getClosest(double [][] arr, int pos1, int pos2,
                                 double target)
    {
        if (target - arr[pos1][0] >= arr[pos2][0] - target)
            return pos2;
        else
            return pos1;
    }

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("/home/tirthankar/PycharmProjects/Codeforces/Bioinformatics Contest 2021/5.txt");
        BufferedReader buffer = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        FileWriter fw=new FileWriter("/home/tirthankar/PycharmProjects/Codeforces/Bioinformatics Contest 2021/output.txt");
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int m = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), n = Integer.parseInt(inp[2]);
            double [][] metabolites = new double[m][2];
            double [] adducts = new double[k], signals = new double[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                metabolites[i][0] = Double.parseDouble(inp[i]);
                metabolites[i][1] = i;
            }
            Arrays.sort(metabolites, (o1, o2) -> {
                if (o1[0] > o2[0])
                    return 1;
                else if (o2[0] > o1[0])
                    return -1;
                else
                    return 0;
            });
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                adducts[i] = Double.parseDouble(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                signals[i] = Double.parseDouble(inp[i]);
            }
            for (double signal : signals) {
                double diff, delta = Integer.MAX_VALUE;
                int posOfAdducts = -1, posOfMetabolites = -1;
                for (int i = 0; i < k; i++) {
                    diff = signal-adducts[i];
                    int j = findClosest(metabolites, diff);
                    if (Math.abs(diff-metabolites[j][0]) < delta){
                        delta = Math.abs(diff-metabolites[j][0]);
                        posOfAdducts = i;
                        posOfMetabolites = (int) metabolites[j][1];
                    }
                }
                sb.append(posOfMetabolites+1).append(" ").append(posOfAdducts+1).append("\n");
            }
        }
        fw.write(sb.toString());
        fw.close();
    }
}
