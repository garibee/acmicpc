import java.util.Arrays;
import java.util.Scanner;

public class 그리디_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] cache = new int[n];
		for(int i = 0;i < n; i++){
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int hap = 0;
		int temp =0;
		for(int i =0; i< n; i++){
			cache[i] = hap = arr[i]+hap+temp;
		}
		int max = 0;
		for(int i =0; i<cache.length;i++){
			max+=cache[i];
		}
		System.out.println(max);
	}
}
