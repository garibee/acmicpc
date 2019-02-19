import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class BFS_유기농배추 {
	protected static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, m, b;
	static int[][] field;
	static boolean[][] isVisit;
	static Queue<Point> que = new LinkedList<Point>();
	static int max = 1;
	static int[] mX = { -1, 0, 1, 0 };
	static int[] mY = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();

		for (int i = 0; i < cnt; i++) {
			m = s.nextInt();
			n = s.nextInt();
			b = s.nextInt();

			field = new int[n][m];
			isVisit = new boolean[n][m];
			for (int j = 0; j < b; j++) {
				int y = s.nextInt();
				int x = s.nextInt();
				field[x][y] = 1;
			}

			bfs(0, 0);
			System.out.println(max);
		}
	}

	public static void bfs(int x, int y) {
		que.add(new Point(x, y));
		isVisit[x][y] = true;

		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int i = 0; i < 4; i++) {
				int right = p.x+mX[i];
				int left = p.y+mY[i];
				if(right<0 || left<0 || right>=m || left>=n) continue;
				if(isVisit[left][right] || field[left][right]==0) continue;
				
				
			}
		}
	}
}
