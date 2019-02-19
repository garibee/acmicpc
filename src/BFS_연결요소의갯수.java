import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_연결요소의갯수 {
	static int n, m;
	static ArrayList<Integer>[] arr;
	static boolean isVisit[];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		arr = (ArrayList<Integer>[]) new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		isVisit = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			arr[x].add(y);
			arr[y].add(x);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (!isVisit[i]) {
				bfs(i);
				++max;
			}
		}
		
		System.out.println(max);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		isVisit[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int t = q.poll();
			
			for (int i = 0; i < arr[t].size(); i++) {
				if(!isVisit[arr[t].get(i)]) {
					q.add(arr[t].get(i));
					isVisit[arr[t].get(i)] = true;
				}
			}
		}
	}
}

