import java.util.ArrayList;
import java.util.Scanner;

public class 브루트_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listTmp = new ArrayList<Integer>();
		int n = sc.nextInt();
		int max = 0;
		int harf = n/2+1;
		for(int i = harf;  i<= n; i++) {
			listTmp = new ArrayList<Integer>();
			int tN = n;
			listTmp.add(tN);
			listTmp.add(i);
			int tmpCnt = 2;
			while(tN >= 0) {
				listTmp.add( (listTmp.get(tmpCnt-2)) - (listTmp.get(tmpCnt-1)));
				++tmpCnt;
				tN = listTmp.get(tmpCnt-2) - listTmp.get(tmpCnt-1);
				if(max<tmpCnt) {
					max = tmpCnt;
					list = listTmp;
				}
			}
		}
		System.out.println(max);
		for(int i =0; i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}