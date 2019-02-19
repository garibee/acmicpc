import java.util.Scanner;

public class DP_합분해{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int k = s.nextInt();
		int[][] dp = new int[k + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				for (int l = 0; l <= j; l++) {
					dp[i][j] = (dp[i][j]+ dp[i - 1][j - l])%1000000000;
				}
			}
		}


		System.out.println(dp[k][n]);
	}
}
