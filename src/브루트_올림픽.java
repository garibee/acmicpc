import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Olympic implements Comparable<Olympic> {
	int gold;
	int silver;
	int bronze;
	int rank;

	public Olympic(int rank, int gold, int silver, int bronze) {
		this.rank = rank;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	@Override
	public int compareTo(Olympic o) {
		if (o.gold !=gold) {
			return o.gold-gold;
		}
		if (o.silver != silver) {
			return o.silver-silver;
		}
		if(o.bronze != bronze) {
			return o.bronze-bronze;
		}
		return 0;
	}
	/*
3 1
2 1 1 0
3 2 3 1
1 1 2 2
	 */
}

public class 브루트_올림픽{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		ArrayList<Olympic> arr = new ArrayList<Olympic>();
		int G=0,S=0,B=0;
		for (int i = 0; i < n; i++) {
			int r = s.nextInt();
			int go = s.nextInt();
			int si = s.nextInt();
			int br = s.nextInt();
			arr.add(new Olympic(r, go, si, br));
			if(r==m) {	
				G = arr.get(i).gold;
				S = arr.get(i).silver;
				B = arr.get(i).bronze;
			}
		}
		s.close();

		
		
		Collections.sort(arr);
//		for(int i =0; i<arr.size();i++) {
//			System.out.println(arr.get(i).rank+" "+arr.get(i).gold+" "+arr.get(i).silver+" "+arr.get(i).bronze);
//		}
		int cnt = 0;		
		for (int i = 0; i <arr.size(); i++) {
			if (arr.get(i).gold == G && 
				arr.get(i).silver == S && 
				arr.get(i).bronze == B) {
				cnt = i+1;
				break;
			}
		}
		System.out.print(cnt);
	}
}


