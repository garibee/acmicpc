import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Stone {
	int index, cnt;
	public Stone(int index, int cnt) {
		this.index = index;
		this.cnt = cnt;
	}
}
public class BFS_돌다리 {
	//static int[][] map;
	static boolean[] isVisit;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int currD = s.nextInt();
		int currJ = s.nextInt();
		isVisit = new boolean[1000001];
		
		int m = bfs(a,b,currD,currJ);
		System.out.println(m);
	}
	
	public static int bfs(int a, int b, int currD, int currJ) {
		int c = 0;
		Queue<Stone> q = new LinkedList<Stone>();
		
		q.add(new Stone(currD,c));
		while(!q.isEmpty()) {
			Stone stone = q.poll();
			int t = stone.index;
			int cnt = stone.cnt;
			if(t==currJ) {
				c = cnt;
				break;
			}
			++cnt;
			if(t-b >= 0 &&!isVisit[t-b]) {
				isVisit[t-b] = true;
				q.add(new Stone(t-b, cnt));
			}
			if(t-a >= 0  &&!isVisit[t-a]) {
				isVisit[t-a] = true;
				q.add(new Stone(t-a, cnt));
			}
			if(t-1 >= 0  &&!isVisit[t-1]) {
				isVisit[t-1] = true;
				q.add(new Stone(t-1, cnt));
			}
			
			if(t*b <= currJ &&!isVisit[t*b]) {
				isVisit[t*b] = true;
				q.add(new Stone(t*b, cnt));
			}
			
			if(t*a <= currJ &&!isVisit[t*a]) {
				isVisit[t*a] = true;
				q.add(new Stone(t*a, cnt));
			}
			
			if(t+b <= currJ &&!isVisit[t+b]) {
				isVisit[t+b] = true;
				q.add(new Stone(t+b, cnt));
			}
			
			if(t+a <= currJ &&!isVisit[t+a]) {
				isVisit[t+a] = true;
				q.add(new Stone(t+a, cnt));
			}
			if(t+1 <= currJ &&!isVisit[t+1]) {
				isVisit[t+1] = true;
				q.add(new Stone(t+1, cnt));
			}
		}
		return c;
	}
}
