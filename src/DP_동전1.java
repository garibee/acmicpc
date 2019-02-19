import java.util.Arrays;
import java.util.Scanner;

public class DP_동전1 {
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
		
		for(int i =0; i<n;i++) {
			arr[i] = s.nextInt();
		}
		cache[0] = 1;
		for(int i =0; i<n;i++) {
			for(int j = arr[i]; j<=m;j++) {
				//System.out.println("i= "+i +" & cache[j]+cache[j-arr[i]] = "+(cache[j]+cache[j-arr[i]]));
				cache[j] = cache[j]+cache[j-arr[i]];
			}
		}
		System.out.println(cache[m]);

	}
}
/*
3 10
1
2
5
*/