import java.util.Scanner;

public class DP_계단오르기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n+1];
		int[][] cache = new int[n+1][2];
		for(int i =1; i<= n; i++) {
			arr[i] = s.nextInt();
		}
		cache[1][0] = cache[1][1] = arr[1];
		
		for(int i =2; i<= n; i++) {
			cache[i][0] = cache[i-2][1]+arr[i];
			cache[i][1] = Math.max(cache[i-2][1],cache[i-1][0])+arr[i];
		}
		System.out.println(Math.max(cache[n][0],cache[n][1]));
	}
}
