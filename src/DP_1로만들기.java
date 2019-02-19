import java.util.Arrays;
import java.util.Scanner;

public class DP_1로만들기 {
	static int[] cache;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache = new int[1000001];
		Arrays.fill(cache, -1);

		cache[1] = 0;
		cache[2] = 1;
		cache[3] = 1;
		for(int i = 4; i<=n;i++) {
			int temp = cache[i-1];
			if(i%3==0) {
				cache[i] = cache[i/3];
				cache[i] = Math.min(cache[i], temp)+1;
			}else if(i%2==0) {
				cache[i] = cache[i/2];
				cache[i] = Math.min(cache[i], temp)+1;
			}else {
				cache[i] = cache[i-1]+1;
			}
		}
		
		System.out.println(cache[n]);
	}
}
