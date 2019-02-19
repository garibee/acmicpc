import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Printer {
	int index;
	int cost;
	boolean check;
	public Printer(int index, int cost, boolean check) {
		this.index = index;
		this.cost = cost;
		this.check = check;
	}
	
}

public class 프린터큐 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		
		while ( num -- >0) {
			ArrayList<Printer> arr = new ArrayList<Printer>();
			int len = s.nextInt();
			int index = s.nextInt();
			for(int i =0; i< len; i++) {
				int cost = s.nextInt();
				if(i==index) {
					arr.add(new Printer(i,cost,true));
				}else {
					arr.add(new Printer(i,cost,false));
				}
			}
			
			boolean c = true;
			int cnt = 0;
			
			while(c) {
				
				int firstIndex =0;
				boolean isExist = false;
				for(int i= 1;i<arr.size();i++) {
					if(arr.get(firstIndex).cost == arr.get(i).cost) continue;
					if(arr.get(firstIndex).cost < arr.get(i).cost) {
						
						arr.add(arr.get(firstIndex));
						arr.remove(firstIndex);
						isExist = true;
					}
				}
				if(!isExist) {
					++cnt;
					
					if(arr.get(firstIndex).check) {
						c = false;
					}else {
						arr.remove(firstIndex);
					}
				}
				
			}
			System.out.println(cnt);
		}
		
	}
}
