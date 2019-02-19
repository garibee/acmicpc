import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_섬의갯수 {
	static int n, m;
	static int[][] map;
	static boolean[][] isVisit;
	static Queue<Land> que = new LinkedList<Land>();
	static int[] mX = { -1, 0, 1, 0, -1, 1, 1, -1}; 
	static int[] mY = { 0, -1, 0, 1, -1, -1, 1, 1 }; 
	static int max = 0;
	static ArrayList<Integer> arr = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			m = s.nextInt();
			n = s.nextInt();
			if(n==0&&m==0) break;
			max = 0;
			map = new int[n][m];
			isVisit = new boolean[n][m];
			for(int i =0; i< n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j] = s.nextInt();
				}
			}
			
			for(int i =0; i< n;i++) {
				for(int j=0;j<m;j++) {
					bfs(i,j);
				}
			}
			
			System.out.println(max);
		}
	}

	public static void bfs(int x, int y) {
		if (map[x][y] ==0) return;
		if (isVisit[x][y]) return;
		que.add(new Land(x, y));
		isVisit[x][y] = true;
		++max;
		while (!que.isEmpty()) {
			
			Land a = que.poll();
			for (int i = 0; i < 8; i++) {
				int nextX = a.x + mX[i];
				int nextY = a.y + mY[i];
				if (nextY >= m || nextX >= n || nextX < 0 || nextY < 0)
					continue;
				if (isVisit[nextX][nextY] || map[nextX][nextY] == 0)
					continue;
				
				que.add(new Land(nextX, nextY));
				isVisit[nextX][nextY] = true;

				//map[nextX][nextY] = max;
			}
		}
	}
}

class Land {
	int x, y;

	public Land(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

 */
