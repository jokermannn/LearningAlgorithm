import java.util.*;
public class Main
{
    public static int[] a = new int[20];
    public static int[][] dp = new int[20][2];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		while(in.hasNext()) {
		    int m = in.nextInt();
		    int n = in.nextInt();
		    if(m ==0 && n==0)
		    break;
		    for(int i = 0;i < 20; i++) 
		        for(int j = 0; j < 2; j++)
		            dp[i][j] = -1;
		    System.out.println(solve(n) - solve(m-1));
		}
	}
	
	private static int solve(int n) {
	    int pos = 0;
	    while(n!= 0) {
	        a[pos++] = n % 10;
	        n /= 10;
	    }
	    return dfs(pos-1, -1, 0, true);
	}
	
	private static int dfs(int pos, int pre, int state, boolean limit) {
	    if(pos == -1) return 1;
	    if(!limit && dp[pos][state] != -1) return dp[pos][state];
	    int temp = 0;
	    int up = limit ? a[pos] : 9;
	    for(int i = 0; i <= up; i++) {
	        if(i == 4) continue;
	        if(pre == 6 && i == 2) continue;
	        int t = i==6 ? 1 : 0;
	        temp += dfs(pos-1, i, t, limit && i == a[pos]);
	    }
	    if(!limit)
	        dp[pos][state] = temp;
	    return temp; 
	    
	}
}