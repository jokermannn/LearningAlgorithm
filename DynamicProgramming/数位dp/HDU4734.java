import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int[] a = new int[10];
    public static int[][] dp = new int[10][2];
    public static long all = 0;
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            for(int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                all = f(a);
                for(int j = 0; j < 10; j++) {
                    for(int k = 0; k < ; k++) {
                        dp[i][j] = -1;
                    }
                }
                System.out.println();
            }
        }
    }
    private static int solve(int n) {
        int pos = 0;
        while(n != 0) {
            a[pos++] = n % 10;
            n /= 10;
        }
        return dfs(pos-1, 0, true);
    }

    private static int dfs(int pos, int sum, boolean limit) {
        if(pos == -1) return 1;
        if(sum > all) return 0;
        if(!limit && dp[10][])
    }

    private static int f(int x) {
        if(x == 0) return 0;
        int ans = f(x/10);
        return ans * 2 + x % 10;
    }
}