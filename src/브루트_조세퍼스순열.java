
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 브루트_조세퍼스순열 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 1; i<= n; i++){
			q.add(i);
		}
		int cnt = 1;
		while(!q.isEmpty()){
			if(cnt==m){
				list.add(q.poll());
				cnt= 1;
			}
			
			if(m!=1){
				Object obj = q.poll();
				if(obj!=null){
					q.add((int)obj);
				}
				
				++cnt;
			}
		}
		
		System.out.print("<");
		for(int i = 0; i< list.size();i++){
			if(i==list.size()-1)
				System.out.print(list.get(i));
			else
				System.out.print(list.get(i)+", ");
		}
		System.out.println(">");
		sc.close();
	}

}
