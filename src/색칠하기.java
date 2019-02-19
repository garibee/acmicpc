import java.util.ArrayList;
import java.util.Scanner;

public class 색칠하기 {
	static ArrayList<Integer>[] arr;
	static int[] colorCheck;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
		while(cnt-- > 0) {
			int v = s.nextInt();
			int e = s.nextInt();
			arr = new ArrayList[v+1];
			colorCheck = new int[v+1];
			for(int i =0; i<= v;i++) {
				arr[i] = new ArrayList<Integer>();
			}
			for(int i =0;i<e;i++) {
				int from = s.nextInt();
				int to = s.nextInt();
				arr[from].add(to);
				arr[to].add(from);
			}
			
			for(int i =1; i<=v;i++) {
				if(colorCheck[i]==0)
					dfs(i,1);
			}
			
			boolean b = false;
			for(int i =1; i<v;i++) {
				for(int j=0;j<arr[i].size();j++) {
					int t = arr[i].get(j);
					if(colorCheck[i]==colorCheck[t]) {
						b = true;
					}
				}
			}
			
			if(b)System.out.println("impossible");
			else System.out.println("possible");
		}	
	}
	public static void dfs(int start, int color) {
		colorCheck[start] = color;
		for(int i =0; i<arr[start].size(); i++) {
			int to = arr[start].get(i);
			if(colorCheck[to]==0)
			dfs(to,3-color );
			
		}
	}
}
