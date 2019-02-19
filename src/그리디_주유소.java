import java.util.Scanner;

public class 그리디_주유소 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] dist = new long[n];
		long[] cost = new long[n];
		
		for(int i =0;i<n-1;i++){
			dist[i] = s.nextLong();
		}
		for(int i =0;i<n;i++){
			cost[i] = s.nextLong();
		}
		
		long maxCost = Integer.MAX_VALUE;
		long sum = 0;
		for(int i = 0; i<n-1;i++){
			if(maxCost>cost[i]) {
				maxCost = cost[i];
			}
			sum += maxCost * dist[i];
		}
		System.out.println(sum);
	}
}
