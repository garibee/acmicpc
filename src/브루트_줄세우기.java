import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 브루트_줄세우기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= n;i++){
			list.add(s.nextInt(), i);
		}
		
		Collections.reverse(list);
		for(int i =0; i < list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
}
