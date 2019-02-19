import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tresure{
	int x, y;
	public Tresure(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 보물섬 {
	static int[][] Imap;
	static int row,col;
	static boolean[][] isVisit;
	static int[][] dist;
	static int[] mX = {-1,0,1,0};
	static int[] mY = {0,-1,0,1};
	static Queue<Tresure> q2 = new LinkedList<Tresure>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		if(row <=0 || col<=0) {
			System.out.println(0);
			return;
		}
		Imap = new int[51][51];
		isVisit = new boolean[51][51];
		dist = new int[51][51];
		for(int i =0; i<row;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == 'W') Imap[i][j] = 0;
				else Imap[i][j] = 1;
			}
		}
		
		for(int i =0; i<row;i++) {
			for(int j =0; j< col; j++) {
				if(Imap[i][j]==1 ) {
					dist[i][j] = bfs(i,j);
					for(int k=0;k<row;k++) {
						for(int l=0;l<col;l++) {
							if(Imap[k][l]>0) {
								Imap[k][l]=1;
							}
						}
						Arrays.fill(isVisit[k], false);
					}
				}
			}
		}
		// Ȯ�ο� ���
//		for(int i =0; i< row; i++) {
//			for(int j= 0; j< col; j++) {
//				System.out.print(dist[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		// �����
		int max = 0;
		for(int i =0; i< row; i++) {
			for(int j= 0; j< col; j++) {
				if(dist[i][j] > max) max = dist[i][j];
			}
			//System.out.println();
		}
		if(max>0) 
			System.out.println(max-1);
		else {
			System.out.println(max);
		}
	}
	
	
	//Ư�� �� ���������� ���� �ָ� ������ �� �����
	public static int bfs(int x, int y) {
		int max = 0;
		Queue<Tresure> q = new LinkedList<Tresure>();
		q.add(new Tresure(x, y));
		isVisit[x][y]=true;
		while(!q.isEmpty()) {
			Tresure l = q.poll();
			for(int i =0; i< 4; i++) {
				int nextX = l.x+mX[i];
				int nextY = l.y+mY[i];
				
				if(nextX <0 || nextY <0 || nextX>=row || nextY>=col) continue;
				if(isVisit[nextX][nextY]==true || Imap[nextX][nextY]==0) continue;
				q.add(new Tresure(nextX, nextY));
				isVisit[nextX][nextY] = true;
				Imap[nextX][nextY] = Imap[l.x][l.y]+1;
				
				if(Imap[nextX][nextY]> max) max = Imap[nextX][nextY];
			}
		}
		
		return max;
	}
}
/*
5 5
LLLLL
WWWWW
LLLLW
WWWLW
LLLLW

5 5
LLWLL
WLWLW
WLWLL
LWWLL
LLWLL

4 4
LLLL
LWLW
LLLW
LWWW
*/

