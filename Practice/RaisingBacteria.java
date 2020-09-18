import java.io.*;
import java.util.*;

public class RaisingBacteria {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        int ans = 1+n%2;
        System.out.println(ans);
    }
}
