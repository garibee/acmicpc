import java.util.Arrays;
import java.util.Scanner;

public class DP_포도주시식{
	static int n;
	static int[] wine;
	static int[][] cache;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		wine = new int[n];
		cache = new int[n][n];
		
		for(int i =0 ; i< n; i++) {
			wine[i] = s.nextInt();
			Arrays.fill(cache[i], -1);
		}
		
		int max = DP(0,0);
		System.out.println(max);
	}
	
	public static int DP(int i, int w) {
		if(w ==3) return Integer.MIN_VALUE;
		if(i >= n) return 0;
		if(cache[i][w] != -1) return cache[i][w];
		
		cache[i][w] = Math.max(DP(i+1,0),DP(i+1,w+1)+wine[i]);
		return cache[i][w];
	}
}
