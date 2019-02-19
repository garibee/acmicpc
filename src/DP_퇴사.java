
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_퇴사 {
	static String filePath = "C://workspace/study/src/input.txt";
	static int[] days;
	static int[] profits;
	static int n;
	static int INF = Integer.MIN_VALUE;
	static int[] cache;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br =new BufferedReader(new FileReader(filePath));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n  = Integer.parseInt(st.nextToken());
		days    = new int[n];
		profits = new int[n];
		cache 	= new int[n];
		Arrays.fill(cache,-1);
		for(int i =0; i< n;i++) {
			 
			st = new StringTokenizer(br.readLine());
			days[i]= Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = DP(0);
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}
	public static int DP(int day) {
		//basis
		if(day>n) return INF;
		if(day == n) return 0;
		//cache
		if(cache[day]!=-1) return cache[day];
		//algorithm
		cache[day]= Math.max(
				DP(day+days[day])+profits[day], 
				DP(day+1));
		return cache[day];
	}
}

