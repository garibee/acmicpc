import java.util.Scanner;

public class 플러그 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
		int sum = 0;
		while (cnt-- > 1) {
			int n = s.nextInt();
			sum += n -1;
		}
		int last = s.nextInt();
		sum = sum+ last;
		System.out.println(sum);
	}
}
