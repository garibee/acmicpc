import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 알파벳거리 {
	static HashMap<Character, Integer>hm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		hm = setHm(new HashMap<Character, Integer>());
		int n =Integer.parseInt(br.readLine());
		while(n-- > 0) {
			ArrayList<Integer> range = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String x = st.nextToken();
			String y = st.nextToken();
			
			int len = y.length();
			for(int i =0;i<len;i++) {
				if(hm.get(x.charAt(i)) <= hm.get(y.charAt(i)) ) {
					range.add((hm.get(y.charAt(i))) - (hm.get(x.charAt(i))));
				}else {
					range.add((hm.get(y.charAt(i))+26) - hm.get(x.charAt(i)));
				}
			}
			System.out.print("Distances: ");
			for(int i =0; i< range.size();i++) {
				System.out.print(range.get(i)+" ");
			}
			System.out.println();
		}
		
		br.close();
		
	}
	public static HashMap<Character, Integer> setHm(HashMap<Character, Integer> hm){
		int num = 0;
		
		for(int i =65;i<=90;i++) {
			hm.put((char)i, ++num);
		}
		return hm;
	}
	

}
