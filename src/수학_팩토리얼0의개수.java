import java.util.Scanner;

public class 수학_팩토리얼0의개수 {
	static int five = 0;
	static int two = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		for (int i = 2; i <= n; i *= 2) {
			two+=n/i;
		}

		for (int j = 5; j <= n; j *= 5) {
			five+=n/j;
		}

		System.out.println(two > five ? five : two);
	}
}
