
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_여행 {
	static int[][] map;

	static void bfs(Queue<Integer> queue, int[] check, int v) {
		queue.add(v);
		check[v] = 1;
		int count = -1;

		while (!queue.isEmpty()) {
			v = queue.poll();

			count++;
			for (int i = 1; i < map.length; i++) {
				if (map[v][i] == 1 && check[i] != 1) {
					queue.add(i);
					check[i] = 1;
				}

			}

		}

		System.out.println(count);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt(); // 국가의 수
			int m = sc.nextInt(); // 비행기의 종류

			map = new int[n + 1][n + 1];
			int[] check = new int[n + 1];
			for (int j = 0; j < n + 1; j++)
				check[j] = 0;

			for (int j = 0; j < m; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				map[a][b] = 1;
				map[b][a] = 1;
			}

			Queue<Integer> queue = new LinkedList();

			bfs(queue, check, 1);

		}

		sc.close();
	}

}
