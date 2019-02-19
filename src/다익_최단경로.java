import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class findMinPath implements Comparable<findMinPath>{
	int to;
	int cost;
	public findMinPath(int to, int cost){
		this.to= to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(findMinPath o) {
		return (int)(cost - o.cost);
	}
}

public class 다익_최단경로 {
	static final int INF = Integer.MAX_VALUE-1;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int start = s.nextInt();
		int[] dist = new int[v+1];
		
		Arrays.fill(dist, INF);
		ArrayList<findMinPath>[] arr = new ArrayList[v+1];
		for(int i = 1; i<=v;i++) {
			arr[i] = new ArrayList<findMinPath>();
		}
		while(e-- > 0) {
			int from 	= s.nextInt();
			int to 		= s.nextInt();
			int cost 	= s.nextInt();
			arr[from].add(new findMinPath(to,cost));
		}
		
		dij(arr, dist, start);
		
		for(int i =1; i< dist.length;i++) {
			if(dist[i]>=INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	public static void dij(ArrayList<findMinPath>[] arr, int[] dist, int start) {
		PriorityQueue<findMinPath> pq = new PriorityQueue<findMinPath>();
		dist[start] = 0;
		pq.add(new findMinPath(start, dist[start]));
		while(!pq.isEmpty()) {
			findMinPath f = pq.poll();
			int from 	= f.to; 
			int cost 	= f.cost;
			if( cost > dist[from]) continue;
			for(int i = 0; i < arr[from].size();i++) {
				int nextCost = arr[from].get(i).cost;
				int nextTo 	 = arr[from].get(i).to;
				if(dist[nextTo] > dist[from] + nextCost && dist[from]!=INF) {
					dist[nextTo] = dist[from]+ nextCost;
					pq.add(new findMinPath(nextTo, dist[nextTo]));
				}
			}
		}
	}
}
