import java.util.Scanner;

public class 브루트_줄서기{
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] arr= new int[n+1];
		boolean[] isVisit= new boolean[n+1];
		for(int i=1; i<=n;i++) {
			arr[i] = i;
		}
		
		for(int i =1;i <= m; i++) {
			int left = s.nextInt();
			int right = s.nextInt();
			arr[left]++;
			arr[right]--;
		}
		
		for(int i=1;i<=n;i++) {
			if(isVisit[arr[i]]) {
				System.out.println("-1");
				return;
			}
			isVisit[arr[i]]=true;
		}
		
		for(int i =1;i<=n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
