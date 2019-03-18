import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Map{
	int x,y;
	public Map(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class matbogi {
	static StringTokenizer st;
	static int row;
	static int col;
	static int[][] map;
	static boolean[][] isVisit;
	static int[] x = {-1, 0, 1, 0};
	static int[] y = {0, -1, 0, 1};
	static String filePath = "C://workspace/acmicpc/src/input.txt";
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		isVisit = new boolean[row][col];
		for(int i =0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			String num =  st.nextToken();
			for(int j = 0; j< num.length();j++) {
				map[i][j] = num.charAt(j)-'0';
			}
		}
		
		int max = findPath(0,0);
		System.out.println(max);
	}
	public static int findPath(int mx, int my) {
		Queue<Map> que = new LinkedList<Map>();
		que.add(new Map(mx,my));
		
		while(!que.isEmpty()) {
			Map m = que.poll();
			// 큐에서 뺀 뒤에 방문 여부를 표시하면  동시에 여러칸으로부터 큐에 중복해서 삽입하게 되므로
			// 큐에넣을때 방문했음을 바로 표시 하는것이 좋음
			// (하단 isVisit[nextX][nextY] = true 구문)
			//isVisit[m.x][m.y] = true;
			for(int i =0; i< 4;i++) {
				int nextX = m.x+x[i];
				int nextY = m.y+y[i];
				if(nextX < 0 || nextY < 0 || nextX>=row || nextY>=col) continue;
				if(map[nextX][nextY]==0 || isVisit[nextX][nextY]) continue;
				que.add(new Map(nextX, nextY));
				isVisit[nextX][nextY] = true;
				map[nextX][nextY] = map[m.x][m.y]+1;
			}
		}
		return map[row-1][col-1];
	}
}
