import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int n;
	static String filePath = "C://workspace/acmicpc/src/input.txt";
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		arr[0] =1;
		arr[1] =1;
		for(int i =2; i<=1000; i++) {
			for(int j = i+i;j<=1000;j+=i) {
				arr[j] = 1;
			}
		}

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i =0; i< n; i++) {
			int su = Integer.parseInt(st.nextToken());
			if(arr[su]==0) cnt++;
		}
		System.out.println(cnt);
	}
}
