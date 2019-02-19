import java.util.Scanner;

public class 모든순열 {
	static boolean[] vis;
	static int[] res;
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		vis = new boolean[n+1];
		res = new int[n+1];
		for(int i =1; i<=n;i++) {
			vis[i] = true;
			dfs(i,1,n);
			vis[i] = false;
		}
	}

	public static void dfs(int target, int start, int end ) {
		res[start] = target;
		if(start == end) {
			for(int i =1;i<=end;i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=end;i++) {
			if(vis[i])continue;
			vis[i] = true;
			dfs(i,start+1,end);
			vis[i] = false;
		}
	}
}
