import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 브루트_회사에있는사람 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int n = s.nextInt();
		for(int i =0; i<n;i++) {
			String name = s.next();
			String inOut = s.next();
			if(inOut.equals("enter")) {
				list.add(name);
			}else {
				list.remove(name);
			}
		}
		
		Collections.sort(list);
		for(int i =list.size()-1;i>=0;i--) {
			System.out.println(list.get(i));
		}
	}
}
