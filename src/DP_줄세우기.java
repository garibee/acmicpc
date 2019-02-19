import java.util.Scanner;

public class DP_줄세우기{
	//LIS
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int[] dp = new int[n];
		int[] array = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}

		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}

		}

		for (int i = 1; i < n; i++) {
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}
		System.out.println(n - ans);
	}
}
