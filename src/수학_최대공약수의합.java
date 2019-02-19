import java.util.Scanner;

public class 수학_최대공약수의합{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		while(n-- > 0) {
			long temp =0;
			int[] arr = new int[101];
			int m = s.nextInt();
			for(int i= 0; i< m; i++) {
				arr[i] = s.nextInt();
			}

			for(int i =0; i<m-1;i++) {
				for(int j =i+1;j<m;j++) {
					temp+=gcd(arr[i],arr[j]);
				}
			}
			System.out.println(temp);
		}
	}
	public static int gcd(int n, int m) {//uclid
		if(m ==0) return n;
		return gcd(m,n%m);
	}
}
