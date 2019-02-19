import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Score implements Comparable<Score> {
	String name;
	int kor;
	int eng;
	int math;

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return this.name;
	}

	public int getKor() {
		return this.kor;
	}

	public int getEng() {
		return this.eng;
	}

	public int getMath() {
		return this.math;
	}

	@Override
	public int compareTo(Score s) {
		if(s.kor-getKor() == 0) {
			if(s.eng-getEng() == 0) {
				if(s.math-getMath() == 0) {
					//if(s.name.compareTo(getName())>0) {
						return s.name.compareTo(getName());
					//}
				}
				return Integer.compare(getMath(), s.math);
			}
			return Integer.compare(s.eng, getEng());
		}
		return Integer.compare(getKor(), s.kor);
	}
}

public class 정렬_국영수 {
	public static void main(String[] args) {
		ArrayList<Score> list = new ArrayList<Score>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		
		for(int i = 0;i<n;i++) {
			String str = s.next();
			int k = s.nextInt();
			int e = s.nextInt();
			int m = s.nextInt();
			list.add(new Score(str,k,e,m));
		}
		Collections.sort(list);
		Collections.reverse(list);
		for(int i =0; i<n;i++) {
			System.out.println(list.get(i).getName());
		}
	}
}
