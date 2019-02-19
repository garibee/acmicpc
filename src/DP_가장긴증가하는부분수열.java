import java.util.Scanner;

public class DP_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] cache = new int[n];
		for(int i =0; i< n;i++) {
			arr[i] = s.nextInt();
			cache[i] = 1;
		}
		
		for(int i = 0; i< n;i++) {
			for(int j =0; j< i; j++) {
				if(arr[i]>arr[j] && cache[i] < cache[j]+1)
					cache[i] = cache[j]+1;
			}
		}
		int max = -1;
		for(int i =0; i< n; i++) {
			if(max< cache[i]) max = cache[i];
		}
		System.out.println(max);
	}
}


