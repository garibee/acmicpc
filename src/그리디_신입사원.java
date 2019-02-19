import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Test implements Comparable<Test> {
	int test, interview;

	public Test(int test, int interview) {
		this.test = test;
		this.interview = interview;
	}

	@Override
	public int compareTo(Test o) {
		return test-o.test;
	}
}

public class 그리디_신입사원{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		while (n-- > 0) {
			int m = s.nextInt();
			ArrayList<Test> arr = new ArrayList<Test>();
			for (int i = 0; i < m; i++) {
				int te = s.nextInt();
				int in = s.nextInt();
				arr.add(new Test(te, in));
			}
			Collections.sort(arr);

			int cnt = 1;// 1��°
			int pivot = arr.get(0).interview;
			for (int i = 1; i < arr.size(); i++) {
				if (pivot > arr.get(i).interview) {
					pivot = arr.get(i).interview;
					++cnt;
				}
			}
			System.out.println(cnt);
		}
		s.close();
	}
}
