import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int open, close;

	public Meeting(int open, int close) {
		this.open = open;
		this.close = close;
	}

	@Override
	public int compareTo(Meeting o) {
		if(close==o.close) return open-o.open;
		return close-o.close;
	}
}

public class 그리디_회의실배정 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Meeting >arr = new ArrayList<Meeting>();
		int w = s.nextInt();
		for (int i = 0; i < w; i++) {
			int o = s.nextInt();
			int c = s.nextInt();
			
			arr.add(new Meeting(o,c));
		}
		Collections.sort(arr);
		
		int cnt =0;
		int t = 0;
		for(int i =0; i< w;i++) {
			if(arr.get(i).open >= t ) {
				cnt++;
				t = arr.get(i).close;
			}
		}
		System.out.println(cnt);
	}
}
