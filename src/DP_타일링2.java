import java.util.Scanner;

public class DP_타일링2 {
	static int cache[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		cache = new int[1001];
		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 3;
		for(int i = 3; i<=n; i++) {
			cache[i] = (cache[i-1]+2*cache[i-2])%10007;
		}
		System.out.println(cache[n]);
	}
}
