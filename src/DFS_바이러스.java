import java.util.ArrayList;
import java.util.Scanner;

public class DFS_바이러스 {
	static boolean[] isVisit;
	static ArrayList<Integer>[] path;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int pathCnt = s.nextInt();
		path = new ArrayList[n+1];
		isVisit = new boolean[n+1];
		for(int i =1; i<= n;i++) path[i] = new ArrayList<Integer>();
		for(int i =0; i<pathCnt; i++) {
			int from = s.nextInt();
			int to = s.nextInt();
			path[from].add(to);
			path[to].add(from);
		}
		
		dfs(1);
		int cnt = 0;
		for(int i =2;i<=n;i++) {
			
			if(isVisit[i]) ++cnt;
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		if(isVisit[start]) return;
		isVisit[start] = true;
		for(int i = 0; i<path[start].size();i++) {
			dfs(path[start].get(i));
		}
	}
}
