import java.util.Arrays;
import java.util.Scanner;

public class 브루트_임시반장정하기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] arr = new int[n][5];
		int[][] know = new int[n][n];
		
		for (int i = 0; i < n; i++) { 
			Arrays.fill(know[i], 0);
			for (int j = 0; j < 5; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		for (int i = n - 1; i >= 0; i--) { 
			for (int j = 0; j < 5; j++) { 
				for(int k = 0; k<n; k++){
					if(k!=i) {
						if (arr[i][j] == arr[k][j]) {
							know[i][k]=1;
						}
					}
				}
			}
		}
		int res = 0;
		int tem = 1;
		for(int i =n-1; i>=0; i--) {
			int c = 0;
			for(int j= n-1; j>=0; j--) {
				if(know[i][j]==1) {
					++c;
				}
				if(c>=res) {
					res = c;
					tem = i+1;
				}
			}
		}
		System.out.println(tem);
	}
}
/*
5
1 2 2 2 2
3 5 4 7 1
6 5 8 3 1
6 1 1 9 3
1 5 8 9 1

*/