import java.util.Scanner;

public class 하노이탑{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println((1<<n)-1);
		hanoi(n,1,3);
	}
	public static void hanoi(int n, int x, int y){
		if(n==0) return;
		hanoi(n-1, x, 6-x-y);
		System.out.println(x+" "+y);
		hanoi(n-1, 6-x-y, y);
	}
}
