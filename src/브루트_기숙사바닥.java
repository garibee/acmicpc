import java.util.ArrayList;
import java.util.Scanner;

public class 브루트_기숙사바닥 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int r = s.nextInt(); // red
		int b = s.nextInt(); // brwn
		int hap = r + b;
		for (int i = 1; i <= hap; i++) {
			if (hap % i == 0) {
				list.add(i);
			}
		}

		int except = b * 2 + 6; // b+2 x 3 // r
		if (except == r) {
			System.out.println((b + 2) + " " + 3);
		} else {
			int size = list.size();
			int left = list.get(size/2);
			int right= list.get(size/2);
			if (size % 2 == 0) {// ¦����
				for(int i = 1 ; i < size-1;i++) {
					int l = (list.get(i)-2) * (list.get(size-(i+1))-2);
					if(l==b) {
						left = list.get(i);
						right = list.get(size-(i+1));
						break;
					}
				}
			}
			System.out.println(Math.max(left, right) + " " + Math.min(left, right));
		}

	}
}
