import java.util.Arrays;
import java.util.Scanner;

public class FW_궁금한민호 {
	static int [][] arr;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		boolean[][] check = new boolean[n][n];
		arr = new int[n][n];
		
		for(int i =0; i< n; i++) {
			for(int j =0; j< n; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		for(int i =0; i<n;i++){
			for(int j =0; j<n; j++) {
				if(arr[i][j] == 0) continue;
				for(int k = 0; k<n; k++) {
					if(k==i || k==j) continue; 
					if(arr[j][k] > arr[j][i]+arr[i][k]) {
						System.out.println("-1");
						return;
					}
					
					if(arr[j][k] == arr[j][i]+arr[i][k]) {
						check[j][k] = true;
					}
				}
			}
		}
		int a = 0;
		for(int i =0; i< n; i++) {
			for(int j =0; j< n; j++) {
				if(!check[i][j]) a+=arr[i][j]; 
			}
			
		}
		System.out.println(a/2);
	}
}
