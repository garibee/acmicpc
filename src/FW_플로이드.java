import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FW_플로이드 {

	static String filePath = "C://workspace/Study/study/input.txt";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[101][101];
		int max = 10000001;
		for(int i=1; i<=n;i++){
			for(int j=1; j<=n;j++){
				if (i != j) arr[i][j] = max; 
			}
		}
		
//		for(int i=1; i<=n;i++){
//			for(int j=1; j<=n;j++){
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}

		for (int p = 1; p <= m; p++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[v][e] = c;
		}
		
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		

		for (int i = 1; i <= n; i++) {
			for(int j = 1; j<=n; j++){
				if (arr[i][j] < max) System.out.print(arr[i][j]);
				else System.out.print("0");
				if (j<n) System.out.print(" ");
			}
			 System.out.println();
		}

	}

}
