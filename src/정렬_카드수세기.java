import java.util.Arrays;
import java.util.Scanner;

public class 정렬_카드수세기 {
	public static void main(String[] args) {
		//ArrayList<Long> arr = new ArrayList<Long>();	
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		long[] arr = new long[n];
		for(int i =0; i < n; i++) {
			long in = s.nextLong();
			arr[i] = in;
		}
		
		Arrays.sort(arr);
		long max = 0;
		long key = arr[0];
		long cnt = 0;
		for(int i= 1; i< n;i++) {
			if(arr[i] == arr[i-1]) {
				++cnt;
			}else {
				cnt = 0;
			}
			if(max<cnt) {
				key = arr[i];
				max = cnt;
			}
		}
		System.out.println(key);
		
	}
}
/*
7
1
2
1
2
3
3
3

*/