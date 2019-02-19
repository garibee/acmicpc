import java.util.Arrays;
import java.util.Scanner;

public class DP_이동하기 {
	static int[][] map;
	static int[][] cache;
	static int row,col;
	static int INF = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		row = s.nextInt();
		col = s.nextInt();
		map = new int[row+1][col+1];
		cache = new int[row+1][col+1];
		
		for(int i = 0; i<row; i++){
			Arrays.fill(cache[i], -1);
			for(int j = 0; j<col;j++) {
				map[i][j] = s.nextInt();
			}
		}
		
		int sum = DP(0,0);
		System.out.println(sum);
	}
	
	public static int DP(int r, int c) {
		if(r>=row || c>=col) return 0;
		if(cache[r][c]!=-1) return cache[r][c];
		cache[r][c] = Math.max(
				DP(r,c+1)+map[r][c],
				Math.max(DP(r+1,c+1)+map[r][c],
						DP(r+1,c)+map[r][c])
		);
		
		return cache[r][c];
	}
}
