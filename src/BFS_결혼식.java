
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_결혼식 {
	static ArrayList<Integer>[] arr;
	static boolean[] isVisit;
	static int res = 0;
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] friend;
	static int num = 0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt(); 
		int m = s.nextInt(); 
		arr = (ArrayList<Integer>[]) new ArrayList[n + 1];
		friend = new boolean[501];
		isVisit = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int r = s.nextInt();
			int c = s.nextInt();
			arr[r].add(c);
			arr[c].add(r);
			if (r == 1) {
				friend[c] = true;
				q.add(c);
			}
			if (c == 1) {
				friend[r] = true;
				q.add(r);
			}
		}
		
//		for(int i =0; i < arr.length;i++){
//			for(int j =0; j<arr[i].size();j++){
//				int aa = arr[i].get(j);
//				System.out.println(i+" // "+aa);
//			}
//		}
		bfs(1);
		for (int i = 0; i < isVisit.length; i++) {
			if (friend[i] == true)
				++num;
		}

		System.out.println(num);
	}

	public static void bfs(int start) {
		//q.add(start);
		isVisit[start] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			for (int j = 0; j < arr[a].size(); j++) { 
				int b = arr[a].get(j);
				if (!isVisit[b] && friend[a]) {
					friend[b] = true;
					isVisit[b] = true;
				}
			}
		}
	}
}
