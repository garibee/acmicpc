import java.util.Scanner;

public class DP_붕어빵판매하기{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n+1];
		int[] cache = new int[n+1];
		for(int i =1; i <= n; i++) {
			arr[i] = s.nextInt();
		}
		//cache[n] = arr[n-i] 
		for(int i =1; i<=n;i++) {
			for(int j =1;j<=i;j++) {
				
				cache[i] = Math.max(cache[i],cache[i-j]+arr[j]);
				//System.out.println(cache[i-j]);
				//System.out.println("i = "+i +" j = "+j +" cache[i] = " +cache[i]+" ");
			}
		}
		
		//for(int i =1; i<= n;i++) {
			//System.out.print(cache[i]+" ");
		//}
		System.out.println(cache[n]);
	}
}
