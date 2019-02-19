
import java.util.Scanner;

public class 수학_골드바흐의추측 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int max = 1000001;
		int[] arr = new int[max];

		for (int i = 0; i < max; i++) {
			arr[i] = i;
		}
		arr[1] = -1;
		for (int i = 2; i < max; i++) {
			if (arr[i] == -1) continue;
			for (int j = i + i; j < max; j += i) {
				arr[j] = -1; // -1�� �ƴ� �͵��� �Ҽ�
			}
		}
		
		int t = 0;
		while (true) {
			int n = s.nextInt();
			boolean bool = false;
			if (n == 0) break;
			
			for(int i = 1; i<n; i++) {
				t = n-i;
				
				if( arr[i]!=-1 && arr[t]!=-1 && t%2==1 && t+i==n) {
					System.out.println(n +" = " + i + " + " + t);
					bool = true;
					break;
				}
			}
			
			if(bool==false) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
			
		}
	}
}
/*
8
20
42
0

*/