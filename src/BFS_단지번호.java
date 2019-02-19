import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_단지번호 {
	static int n;
	static int[][] map;
	static boolean[][] isVisit;
	static Queue<Apart> que = new LinkedList<Apart>();
	static int[] mX = { -1, 0, 1, 0 };
	static int[] mY = { 0, -1, 0, 1 };
	static int max=0;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		map = new int[n][n];
		isVisit = new boolean[n][n];
		for(int i =0;i<n;i++) {
			String str = s.next();
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		for(int i =0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				
				bfs(i,j);
				if(max!=0) {
					arr.add(max);
				}
				max=0;
			}
		}
		/*
5
11111
11111
11011
11111
11110
		 */
//		for(int i =0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for(int i =0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
	}
	
	public static void bfs(int x, int y) {
		if(map[x][y]==0) return;
		if(isVisit[x][y]) return;

		isVisit[x][y] = true;
		//map[x][y] = max;
		que.add(new Apart(x,y));
		while(!que.isEmpty()) {
			++max;
			Apart a = que.poll();
			for(int i=0;i<4;i++) {
				int nextX = a.x+mX[i];
				int nextY = a.y+mY[i];
				if(nextY>=n || nextX>=n || nextX<0 || nextY<0) continue;
				if(isVisit[nextX][nextY] || map[nextX][nextY]==0) continue;
				que.add(new Apart(nextX,nextY));
				isVisit[nextX][nextY] = true;

				map[nextX][nextY] = max;
			}
		}
	}
	
}
class Apart{
	int x, y;
	public Apart(int x, int y){
		this.x = x;
		this.y = y;
	}
}