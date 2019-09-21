import java.util.Scanner;

public class Main {
    public static int[] a = new int[20];
    public static int[][] dp = new int[20][1700]; 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for(int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(solve(b) - solve(a-1));
            }
        }
    }
    private static int solve(long x) {
        int pos = 0;
        while(x != 0) {
            a[pos++] = (int)(x % 10);
            x /= 10;
        }
        return dfs();
    }
    private static int dfs(int pos, int pre_sum , int nxt_sum,boolean limit) {
        if(pos == 0) return pre_sum == 0 ? 1 : 0;
        if(pre_sum > nxt_sum) return 0;
        if(pre_sum == nxt_sum) return 1;
        if(!limit && dp[pos][pre_sum] != -1) return dp[pos][pre_sum];
        int up = limit ? a[pos] : 9;
        int temp = 0;
        for(int i = 0; i < up; i++) {
            temp += dfs(pos, , , );
        }
        if(!limit) dp[pos][pre_sum] = temp;
        return temp;
    }
}