import java.util.Arrays;
import java.util.Scanner;

public class 마리오 {
	static int[] arr = new int[10];
	static int[] cache = new int[10];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = 10;
		Arrays.fill(cache, -1);
		for(int i=0;i<cnt;i++) {
			arr[i] = s.nextInt();
		}
		int sum = 0;
		int upRange = 0;
		int doRange = 0;
		int res = 0;
		int top = 0;
		int bot = 0;
		for(int i =0; i< cnt;i++) {
			sum+=arr[i];
			if(sum==100) {
				//res = sum;
				System.out.println(sum);
				return;
			}else {
				if(sum>100) {
					upRange = sum-100;
					top = sum;
					break;
				}else {
					doRange = 100-sum;
					bot = sum;
				}
			}
		}
		System.out.println(upRange-doRange);
		if(sum<100) {
			System.out.println(sum);
		}else {
			if(upRange > doRange) System.out.println(bot);
			else if(doRange > upRange) System.out.println(top);
			else System.out.println(top);
		}
	}
}
/*
99
2
1
2
3
4
5
6
7
8


*/