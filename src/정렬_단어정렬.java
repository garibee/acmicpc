import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 정렬_단어정렬 {
	static StringTokenizer st;
	static int n;
	static String filePath = "C://workspace/acmicpc/src/input.txt";
	
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayList<String> str = new ArrayList<String>();
		for(int i =0; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			str.add(st.nextToken());
		}
		Collections.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length()) // 길이가 짧은 순으로 
					return -1;
				if(o1.length()==o2.length()) { // 길이가 같으면
					return o1.compareTo(o2);
				}
				return 1;
			}
		} );
		
		System.out.println(str.get(0));
		for(int i =1; i< n; i++) {
			if(str.get(i).equals(str.get(i-1))) continue;
			System.out.println(str.get(i));
		}
	}
}
