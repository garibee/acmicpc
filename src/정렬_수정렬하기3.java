import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬_수정렬하기3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[10001];
		for(int i =0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); 
			arr[t]++;
		}
		
		for(int i =1; i<= arr.length-1; i++) {
			for(int j = 0; j < arr[i]; j++) {
				if(arr[i]!=0) {
					bw.write(String.valueOf(i));
					bw.newLine();
				}
			}
		}
		//bw.flush();
		bw.close();
		br.close();
		
	}
}
