import java.util.Arrays;
import java.util.Scanner;

public class 이분_예산 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		int sum = 0;
		for(int i =0; i<n;i++) {
			arr[i]= s.nextInt();
			sum+=arr[i];
		}
		int num = s.nextInt();
		Arrays.sort(arr);
		
		if(sum<num) { 
			System.out.println(arr[arr.length-1]);
		}else {
			System.out.println(search(arr,num));
		}
	}
	public static int search(int[] arr, int num) {
		int n = arr.length;
		int left = num/n;
		int right = arr[n-1]; 
		while(left<=right) {
			int mid = (left+right)/2;
			int temp = num;
			for(int i =0; i< arr.length;i++) {
				if(arr[i] <= mid) {
					temp -=arr[i];
				}else {
					temp -=mid;
				}
			}
			
			if(temp>=0) left = mid +1;
			else right = mid-1;
		}
		return right;
	}
}
