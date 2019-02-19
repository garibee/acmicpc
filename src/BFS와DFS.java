import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS와DFS {
	static int n;
	static int v;
	static int start;
	static int[][] map;
	static boolean[] isVisit;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		v = s.nextInt();
		start = s.nextInt();
		isVisit = new boolean[10002];
		Arrays.fill(isVisit, false);
		
		map = new int[1001][10002];
		
		for(int i =1;i <= v; i++) {
			int left = s.nextInt();
			int right = s.nextInt();
			map[left][right] = 1;
			map[right][left] = 1;
		}
		
		dfs(start);
		System.out.println();
		Arrays.fill(isVisit, false);
		bfs(start);
	}
	public static void dfs(int i) {
		isVisit[i] = true;
		System.out.print(i+" ");
		for(int t =1; t<=n;t++) {
			if(!isVisit[t]&&map[i][t]==1) {
				dfs(t);
			}
		}
	}
	
	public static void bfs(int i) {
		q.add(i);
		isVisit[i] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			System.out.print(a+" ");
			for(int k=1;k<=n;k++) {
				if(!isVisit[k]&&map[a][k]==1) {
					q.add(k);
					isVisit[k] = true;
					
				}
			}
		}
	}
}
/*
4 5 3
1 2
1 3
1 4
2 4
3 4
*/
