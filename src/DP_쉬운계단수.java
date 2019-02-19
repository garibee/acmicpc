import java.util.Scanner;

public class DP_쉬운계단수{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long cache[][] = new long[101][11];
		for (int i = 1; i <= 9; i++)
			cache[1][i] = 1;// ���ڸ��� ó��

		for (int i = 2; i <= n; i++) {
			cache[i][0] = cache[i-1][1]; 
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					cache[i][j] = cache[i - 1][j + 1]%1000000000;
				} else if (j == 9) {
					cache[i][j] = cache[i - 1][j - 1]%1000000000;
				} else {
					cache[i][j] = cache[i - 1][j - 1] + cache[i - 1][j + 1]%1000000000;
				}
			}
		}
		long sum = 0;
		for(int i =0; i<=9;i++) {
			sum+= cache[n][i];
		}
		System.out.println(sum%1000000000);
	}
}
