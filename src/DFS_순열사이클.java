import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS_순열사이클{
	static ArrayList<Integer>[] arr;
	static boolean[] isVisit;
	static int cnt, n, res;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		cnt = s.nextInt();
		while (cnt-- > 0) {
			res = 0;
			n = s.nextInt();
			arr = (ArrayList<Integer>[]) new ArrayList[n + 1];
			isVisit = new boolean[n + 1];
			for(int i =1; i<=n;i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for (int i = 1; i <= n; i++) {
				int p = s.nextInt();
				arr[i].add(p);
			}

			for (int i = 1; i < arr.length; i++) {

				if (!isVisit[i]) {
					++res;
					dfs(i);
				}
			}

			System.out.println(res);
		}

	}

	public static void dfs(int start) {
		//if(isVisit[start]) return;
		isVisit[start]= true;
		for (int i = 0; i < arr[start].size(); i++) {
			int p = arr[start].get(i);

			if(!isVisit[p]) {
				isVisit[p] = true;
				dfs(p);
			}
		}
	}
}
/*
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8

*/
