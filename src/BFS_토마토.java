import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Farm{
	int x,y;
	public Farm(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BFS_토마토 {
	static int n,m;
	static int[][] map;
	static boolean[][] isVisit;
	static int[] mX = {-1,0,1,0};
	static int[] mY = {0,-1,0,1};
	static Queue<Farm> que = new LinkedList<Farm>();
	static int max = 1;
	static int oneCnt = 0;
	static int oneChk = 0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		m = s.nextInt();
		n = s.nextInt();
		map  = new int[n][m];
		isVisit = new boolean[n][m];
		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				map[i][j] = s.nextInt();
			}
		}

		boolean oneChk = false;
		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j]>0) {
					que.add(new Farm(i,j));
				}
				
				if(map[i][j]==0) oneChk = true;
			}
		}
		
		bfs();

		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j]==0) {
					max = 0;
					break;
				}
			}
			if(max == 0) break;
		}
		
		
		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j]==0) { 
					max = 0;
					break;
				}
			}
			if(max == 0) break;
		}
		
		if(!oneChk) System.out.println(0);
		else System.out.println((max-1));
	}
	
	public static void bfs() {
		while(!que.isEmpty()) {
			Farm p = que.poll();
			isVisit[p.x][p.y] = true;
			for(int i=0;i<4;i++) {
				int nextX = p.x+mX[i];
				int nextY = p.y+mY[i];
				if(nextX >= n || nextY >= m || nextX <0  || nextY < 0) continue;
				if(isVisit[nextX][nextY] || map[nextX][nextY] == -1) continue;
				
				if(map[nextX][nextY]==0) {
					que.add(new Farm(nextX, nextY));
					isVisit[nextX][nextY]=true;
					map[nextX][nextY] = map[p.x][p.y]+1;
					max = max < map[nextX][nextY] ? map[nextX][nextY]:max;
				}
			}
		}
	}
}
