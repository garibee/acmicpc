import java.util.Scanner;

class 인공지능시계 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int hour	= s.nextInt();
		int minute 	= s.nextInt();
		int seconds = s.nextInt();
		int cookTime = s.nextInt();
		
		int sec = ((cookTime + seconds) % 60);
		int min = (((cookTime + seconds) / 60) + minute) % 60;
		int tim = ((((cookTime + seconds) / 60) + minute) / 60 + hour) % 24;

		System.out.println(tim+" "+min+" "+sec);

	}
}