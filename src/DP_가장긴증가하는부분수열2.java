import java.util.Scanner;

public class DP_가장긴증가하는부분수열2{
	public static int[] arr;
	public static int arrLen = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roof = sc.nextInt();
		arr = new int[roof];
		
		for(int i=0; i<roof; i++) {
			int num = sc.nextInt();
			int index = binSeek(num, 0, arrLen);
			
			arr[index] = num;
		}
		
		System.out.print(arrLen);
		
		sc.close();
	}
		
		public static int binSeek(int num, int left, int right) {
			int mid = (left + right)/2;
			
			if(left >= right) {
				if(arr[left] < num)
					arrLen++;
				
				return left;
			}
			
			else if(arr[mid] > num)
				return binSeek(num, left, mid);
			
			else if(arr[mid] < num)
				return binSeek(num, mid+1, right);
			
			else
				return mid;
		
	}
}
