import java.util.Scanner;

public class 등차수열의위치 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int find = s.nextInt();
		
		int t = n;
		int c = 0;

		for(int i =1;  t < 1000000; i++) {
			
			if(t==find) {
				c = i;
				break;
			}
			t+=m;
		}
		
		System.out.println(c==0?"X":c);
	}
}
