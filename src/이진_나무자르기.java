import java.util.Scanner;

public class 이진_나무자르기 {
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		arr = new int[n];
		int maxParam = 0;
		for(int i =0; i< n;i++) {
			arr[i] = s.nextInt();
			if(maxParam<arr[i]) maxParam = arr[i];
		}
		
		long max = findTree(m,maxParam);
		System.out.println(max);
	}
	public static long findTree(int m, int maxParam) {
		long left = 0;
		long right = maxParam;
		long result = 0;
		while(left<=right) {
			long temp = 0;
			long mid = (left+right)/2;
			for(int i= 0; i<arr.length;i++) {
				if(mid<arr[i]) temp += arr[i]-mid;
			}

			if(temp>=m) {
				result = mid;
				left = mid+1;
			}else {
				if(temp>m) {
					left = mid+1;
				}else{
					right = mid -1;
				}
			}
		}
		return result;
	}
}
