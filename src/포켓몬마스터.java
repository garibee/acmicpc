import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 포켓몬마스터 {
	static String filePath = "C://workspace/study/src/input.txt";
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br =new BufferedReader(new FileReader(filePath));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		String[] str = new String[n+1];
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 1; i <= n; i++) {
			st= new StringTokenizer(br.readLine());
			str[i] = st.nextToken(); 
			hm.put(str[i], i);
		}
		
		for(int i =0; i< find; i++) {
			st = new StringTokenizer(br.readLine());
			String r = st.nextToken();
			if(isNumeric(r)) {
				int f = Integer.parseInt(r);
				bw.write( String.valueOf(str[f]) );
			}else {
				bw.write(String.valueOf(hm.get(r)));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isNumeric(String s) {
		try {
			int a = Integer.parseInt(s);
			return true;
		}catch(NumberFormatException n) {
			return false;
		}
	}
}
