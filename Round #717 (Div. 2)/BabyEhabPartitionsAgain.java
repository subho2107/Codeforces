// taken from https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BabyEhabPartitionsAgain {
    static boolean[][] dp;
    static int cnt;
    static HashMap<Integer, Integer> freq;

    static void updateFreq(ArrayList<Integer> v) {
        HashSet<Integer> set = new HashSet<>(v);
        cnt++;
        for (int num : set) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    static void printSubsetsRec(int arr[], int i, int sum,
                                ArrayList<Integer> p) {
        if (i == 0 && sum != 0 && dp[0][sum]) {
            p.add(arr[i]);
            updateFreq(p);
            p.clear();
            return;
        }

        if (i == 0 && sum == 0) {
            updateFreq(p);
            p.clear();
            return;
        }

        if (dp[i - 1][sum]) {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i - 1, sum, b);
        }

        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
            p.add(arr[i]);
            printSubsetsRec(arr, i - 1, sum - arr[i], p);
        }
    }

    static void printAllSubsets(int arr[], int n, int sum) {
        if (n == 0 || sum < 0)
            return;

        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] ||
                        dp[i - 1][j - arr[i]])
                        : dp[i - 1][j];
        if (!dp[n - 1][sum]) {
            cnt = -1;
            return;
        }
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n - 1, sum, p);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        int arr[] = new int[n];
        int sum = 0;
        String[] inp = buffer.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            System.out.println(0);
        } else {
            freq = new HashMap<>();
            cnt = 0;
            printAllSubsets(arr, n, sum / 2);
            if (cnt == -1) {
                System.out.println(0);
            } else {
                int max = 0, maxKey = -1;
                for (int key : freq.keySet()) {
                    if (freq.get(key) > max) {
                        max = freq.get(key);
                        maxKey = key;
                    }
                }
                System.out.println(1);
                for (int i = 0; i < n; i++) {
                    if (arr[i] == maxKey) {
                        System.out.println(i + 1);
                        break;
                    }
                }
            }
        }
    }
}
