import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_미로탐색{
	static int n, m;
	static int[][] map;
	static boolean[][] isVisit;
	static int[] mx = { -1, 0, 1, 0 };
	static int[] my = { 0, -1, 0, 1 };
	static Queue<Point> que = new LinkedList<Point>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		map = new int[n][m];
		isVisit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = s.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		bfs(0, 0);
		System.out.println(map[n-1][m-1]);

	}

	public static void bfs(int x, int y) {
		que.add(new Point(x,y));
		isVisit[x][y] = true;
		while(!que.isEmpty()) {
			Point p = que.poll();
			for(int i =0;i<4;i++) {
				int nextX = p.x+mx[i];
				int nextY = p.y+my[i];
				if(nextX <0 || nextY<0 || nextX>=n || nextY>=m) continue;
				if(isVisit[nextX][nextY] || map[nextX][nextY]==0) continue;
				
				map[nextX][nextY] = map[p.x][p.y]+1;
				isVisit[nextX][nextY] = true;
				que.add(new Point(nextX, nextY));
			}
		}
	}
}
