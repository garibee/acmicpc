
import java.util.HashMap;
import java.util.Scanner;

public class 진수변환기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int parser = s.nextInt();

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		hm.put(10, "A");
		hm.put(11, "B");
		hm.put(12, "C");
		hm.put(13, "D");
		hm.put(14, "E");
		hm.put(15, "F");
		String str = "";
		
		if(num == 0) {
			System.out.println(0);
		}else{
			while (num >= 1) {
				if (parser >= 10 && num >= 10) {
					 if (hm.get(num % parser) != null) {
						str += hm.get(num % parser);
					} else {
						str += num % parser;
					}
				} else {
					str += num % parser;
				}
				num = num / parser;
			}
	
			for (int i = str.length() - 1; i >= 0; i--) {
				System.out.print(str.charAt(i));
			}
		}
	}

}
