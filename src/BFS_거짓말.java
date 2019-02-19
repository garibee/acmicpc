
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_거짓말 {
	static class P {
		int x, y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, p;
	static ArrayList<Integer>[] res;
	static boolean[] knows;
	static int[][] list;
	static boolean[][] isVisit;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		p = s.nextInt();
		knows = new boolean[51];
		list = new int[51][51];

		res = (ArrayList<Integer>[]) new ArrayList[m];
		for (int i = 0; i < m; i++) {
			res[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < list.length; i++) {
			Arrays.fill(list[i], 0);
		}
		Arrays.fill(knows, false);

		for (int i = 0; i < p; i++) {
			int t = s.nextInt();
			knows[t] = true;
		}

		for (int i = 0; i < m; i++) {
			int person = s.nextInt();
			int a = s.nextInt();
			list[a][a] = 1;
			res[i].add(a);
			for (int j = 0; j < person - 1; j++) {
				int b = s.nextInt();
				list[a][b] = 1;
				list[b][a] = 1;
				a = b;
				res[i].add(b);
			}
		}

		for (int i = 0; i <= n; i++) {
			bfs(i);
		}

		ArrayList<Integer> k = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			if (knows[i] == false) {
				k.add(i);
			}
		}

		int temp = 0;
		for (int i = 0; i < m; i++) {
			boolean b = true;
			if (k.size() > 0) {
				for (int j = 0; j < res[i].size(); j++) {
					if (knows[res[i].get(j)] == true) {
						b = false;
					}
				}
				if (b == true)
					++temp;
			}
		}

		System.out.println(temp);
		s.close();
	}

	static void bfs(int start) {
		isVisit = new boolean[n + 1][n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int s = q.poll();
			for (int i = 0; i <= n; i++) {
				if (list[s][i] == 1 && !isVisit[s][i]) {
					if (knows[i])
						knows[s] = true;
					isVisit[s][i] = true;
					q.add(i);
				}
			}
		}
	}
}