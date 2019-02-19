import java.util.Arrays;
import java.util.Scanner;

public class DP_정수삼각형 {
	static int n;
	static int[][] arr;
	static int[][] cache;
	static int INF = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n 		= s.nextInt();
		arr 	= new int[n+1][n+1];
		cache 	= new int[n+1][n+1];
		for(int i =1; i <= n; i++) {
			Arrays.fill(cache[i],-1);
			for(int j = 1;j<=i;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		int max = DP(1,1);
		System.out.println(max);
	}
	
	public static int DP(int i, int j) {
		if(i==n+1 ) return 0;
//		System.out.println(arr[i][j]);	
//		DP(i+1,j);
//		DP(i+1,j+1);
		
		if(cache[i][j]!=-1) return cache[i][j];
		cache[i][j] = Math.max(DP(i+1,j),DP(i+1,j+1))+arr[i][j];
		return cache[i][j];
	}
}
/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

*/