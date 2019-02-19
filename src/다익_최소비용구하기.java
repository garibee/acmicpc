import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class D implements Comparable<D>{
	int to;
	long cost;
	public D(int to, long cost) {
		this.to		= to;
		this.cost 	= cost;
	}
	
	@Override
	public int compareTo(D o) {
		return (int)(cost - o.cost);
	}
}

public class 다익_최소비용구하기 {
	public static void main(String[] args) throws Exception{
		//BufferedReader br = new BufferedReader(new FileReader("C://workspace/study/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //������ ����
		int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()); // ���� ��
		//boolean[] check = new boolean[n+1];
		long[] dist 		= new long[n+1];
		
		//Arrays.fill(check, false);
		Arrays.fill(dist, 100000000);
		
		//init
		ArrayList<D>[] arr = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) 	arr[i] = new ArrayList<D>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from 	= Integer.parseInt(st.nextToken());
			int to 		= Integer.parseInt(st.nextToken());
			int cost 	= Integer.parseInt(st.nextToken());
			arr[from].add(new D(to,cost));
		}
		st = new StringTokenizer(br.readLine());
		int start 	= Integer.parseInt(st.nextToken());
		int end		= Integer.parseInt(st.nextToken());
		
		dijkstra(arr, dist, start);
		
		//for(int i=1; i<dist.length;i++)System.out.print(dist[i]+" ");
		System.out.println(dist[end]);
	}
	public static void dijkstra(ArrayList<D>[] arr,long[] dist, int start) {
		PriorityQueue<D> pq = new PriorityQueue<D>();
		dist[start] = 0;
		pq.add(new D(start, dist[start]));
		while(!pq.isEmpty()) {
			D d 	 	= pq.poll();
			int to 	 	= d.to;
			long cost 	= d.cost;
			if(cost > dist[to]) continue; // ���� �Ÿ���뺸��, ������ �� �Ÿ������ ������ ���
			for(int j =0; j< arr[to].size();j++) {
				long nextCost = arr[to].get(j).cost;
				int nextPos = arr[to].get(j).to;
				if( dist[nextPos] >=dist[to]+ nextCost) {
					dist[nextPos] = dist[to]+ nextCost;
					pq.add(new D(nextPos, dist[nextPos]));
				}
			}
		}
	}
}
