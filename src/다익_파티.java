import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Path implements Comparable<Path>{
	int to;
	int cost ;
	public Path(int to, int cost) {
		this.to= to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Path o) {
		return cost - o.cost;
	}
}

public class 다익_파티 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int city = s.nextInt(); //���� ��
		int path = s.nextInt(); //���ð��� ����
		int arrive = s.nextInt(); // ������
		int[] dist = new int[city+1];
		int[] backDist = new int[city+1];
		ArrayList<Path>[] arr = new ArrayList[city+1];
		ArrayList<Path>[] backArr = new ArrayList[city+1];
		
		Arrays.fill(dist, 100000000);
		Arrays.fill(backDist, 100000000);
		for(int i =0; i<= city; i++) {
			arr[i] = new ArrayList<Path>();
			backArr[i] =new ArrayList<Path>(); 
		}
		for(int i =0; i<path; i++) {
			int from = s.nextInt();
			int to   = s.nextInt();
			int cost = s.nextInt();
			arr[from].add(new Path(to,cost));
			backArr[to].add(new Path(from,cost));
		}
		dijkstra(arr,dist,arrive);
		dijkstra(backArr,backDist,arrive);
	
		int maxDist = 0;
		for(int i=1;i<=city;i++) { //�ִ밪 Ž��
			if(maxDist<dist[i]+backDist[i]) {
				maxDist = dist[i]+backDist[i];
			}
		}
		
		System.out.println(maxDist);
		s.close();
	}
	
	public static void dijkstra(ArrayList<Path>[] arr, int[] dist, int a) {
		PriorityQueue<Path> pq = new PriorityQueue<Path>();
		dist[a] =0;
		pq.add(new Path(a,dist[a]));
		while(!pq.isEmpty()) {
			Path p = pq.poll();
			int from = p.to;
			int cost = p.cost;
			if(cost > dist[from]) continue;
			for(int i =0; i< arr[from].size(); i++) {
				int nextTo = arr[from].get(i).to;
				int nextCost = arr[from].get(i).cost;
				if(dist[nextTo] > dist[from]+ nextCost) {
					dist[nextTo] = dist[from]+ nextCost;
					pq.add(new Path(nextTo,dist[nextTo]));
				}
			}
		}
	}
}
