import java.util.Scanner;

public class Main {
    public static int[] a = new int[10];
    public static int[][] dp = new int[10][5000];
    public static int all = 0;
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Case = 1;
        while(in.hasNext()) {
            int n = in.nextInt();
            
            for(int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                all = f(x);
                for(int j = 0; j < 10; j++) {
                    for(int k = 0; k < 5000; k++) {
                        dp[j][k] = -1;
                    }
                }
                System.out.printf("Case #%d: %d",Case++, solve(y));
                System.out.println();
            }
        }
        in.close();
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
        if(pos == -1) return sum <= all ? 1 : 0;
        if(sum > all) return 0;
        if(!limit && dp[pos][all-sum] != -1) return dp[pos][all-sum];
        int up = limit ? a[pos] : 9;
        int temp = 0;
        for(int i = 0; i <= up; i++) {
            temp += dfs(pos-1, sum+i*(1<<pos), limit && i == a[pos]);
        }
        if(!limit)
            dp[pos][all-sum] = temp;
        return temp;
    }

    private static int f(int x) {
        if(x == 0) return 0;
        int ans = f(x/10);
        return ans * 2 + x % 10;
    }
}