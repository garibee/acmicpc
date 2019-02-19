import java.util.Scanner;

public class DP_연속합{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] cache = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		cache[0] = arr[0];
		for (int i = 1; i < n; i++) {
			cache[i] = arr[i];
			if (cache[i] < cache[i-1] + arr[i]) {
				cache[i] = cache[i-1] + arr[i];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (cache[i] > max)
				max = cache[i];
		}
		System.out.println(max);
	}
	//         1   2 3 4  5  6   7   8  9 10
	//arr[i]   10 -4 3 1  5  6  35  12 21 -1
	//cac[i]   10 6 9 10 15 21 -14  12 33 32
}
