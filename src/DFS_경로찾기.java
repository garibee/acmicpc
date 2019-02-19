import java.util.Scanner;

public class DFS_경로찾기{
	static int[][] arr;
	static boolean[][] isVisit;
	static int n;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		arr = new int[n+1][n+1];
		isVisit = new boolean[n+1][n+1];
		for(int i =1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		//floyd
		for(int i = 1; i<=n;i++) {
			for(int j = 1; j<=n; j++) {
				for(int k = 1; k<=n; k++) {
					if(arr[j][i]== 1 && arr[i][k]==1 )
						arr[j][k] = 1;
				}
			}
		}

		
		for(int i =1; i<=n;i++) {
			for(int j=1; j<=n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
