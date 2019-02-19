import java.util.Arrays;
import java.util.Scanner;

public class DP_헤일스톤수열{
	static int n;
	static int[] arr;
	static int[] cache;
	static int max;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		
		for(int i =0; i<n;i++) {

			int m = s.nextInt();
			max = m;
			while(m>1) {
				if(m%2==0) {
					
					m=m/2;
					if(m==1) break;
				}
				if(m%2==1) {
					m=m*3+1;
					if(m==1) break;
				}
				
				if(m>max) max = m;
			}
			
			System.out.println(max);
		}

	}
	public static int DP(int m) {
		if(max<m) max = m;
		if(m==1) return 1;
		if(cache[m]!=-1) return cache[m];
		if(m%2==0) {
			cache[m] = DP(m/2);
			return cache[m];
		}

		if(m%2==1) {
			cache[m] = DP(m*3+1);
		}
		
		return cache[m];
	}
}
