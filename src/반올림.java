
import java.util.Scanner;

public class 반올림 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int t = 1;
		while(n>t*10){
			n+=5*t;
			t*=10;
			n-=n%t;
		}
		System.out.println(n);
		
	}
}
