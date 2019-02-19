import java.util.Scanner;

public class 수학_소인수분해 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int upper = 2;
		while(n>1) {
			if(n%upper==0) {
				System.out.println(upper);
				n=n/upper;
				upper = 2;
			}else {
				++upper;
			}
		}
	}
}
