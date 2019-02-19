import java.util.Arrays;
import java.util.Scanner;

public class DP_동전2 {
	static int n,m;
	static int[] arr;
	static int[] cache;
	static int INF = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		arr = new int[n];
		cache = new int[100001];
		Arrays.fill(cache, 1000001);
		for(int i =0; i<n;i++) {
			arr[i] = s.nextInt();
		}
		cache[0] = 0;
		for(int i =0; i<n;i++) {
			for(int j = arr[i]; j<=m;j++) {
				cache[j] = Math.min(cache[j],cache[j-arr[i]]+1);
			}
		}
		
		if(cache[m]==1000001) System.out.println("-1");
		else System.out.println(cache[m]);

	}
}
