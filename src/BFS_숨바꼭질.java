import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Find{
	int pos, depth;
	public Find(int pos, int depth) {
		this.pos = pos;
		this.depth = depth;
	}
}
public class BFS_숨바꼭질{
	static boolean[] isVisit = new boolean[1000001];
	static Queue<Find> q = new LinkedList<Find>();
	static int n, m, max=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		bfs();
		System.out.println(max);
		s.close();
	}
	
	public static void bfs() {
		q.add(new Find(n,0));
		isVisit[n] = true;
		while(!q.isEmpty()) {
			Find f = q.poll();
			int pos = f.pos;
			int depth = f.depth;
			if(pos==m) continue;
			if(pos+1 == m || pos-1 ==m || pos*2==m) {
				++depth;
				max = depth;
				break;
			}
			if(pos*2<100001 &&  !isVisit[pos*2] ) {
				q.add(new Find(pos*2, depth+1));
				isVisit[pos*2] = true;
			}
			if(pos+1>0 && !isVisit[pos+1] ) {
				q.add(new Find(pos+1, depth+1));
				isVisit[pos+1] = true;
			}
			if(pos-1>0  && !isVisit[pos-1] ) {
				q.add(new Find(pos-1, depth+1));
				isVisit[pos-1] = true;
			}
		}
	}
}
