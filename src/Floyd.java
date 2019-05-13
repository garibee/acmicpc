import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {
	static int [][] arr;
	static int n;
	static int bus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("C://workspace/Study/src/input.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		bus = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];

		for(int i =1;i<=n;i++){
			Arrays.fill(arr[i], 1000001);
			arr[i][i] = 0;
		}
		for(int i =0 ; i< bus;i++){
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
//			arr[from][to] = cost;
			arr[from][to] = Math.min(arr[from][to],cost); //넣으면서부터 작은것 넣기
		}
		
		for(int i = 1; i <= n; i++){
			for(int j =1; j <= n; j++){
				for(int k= 1; k <=n;k++){
					if( arr[j][k] > arr[j][i]+arr[i][k]){
						arr[j][k] = arr[j][i]+arr[i][k];
					}
				}
			}
		}
		
		for(int i = 1; i <= n;i++){
			for(int j =1; j<= n;j++){
				if(arr[i][j]==1000001)
					System.out.print("0 ");
				else 
					System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}