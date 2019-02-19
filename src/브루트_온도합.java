import java.util.ArrayList;
import java.util.Scanner;

public class 브루트_온도합{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		ArrayList<Integer> arr=  new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			arr.add(s.nextInt());
		}
		
		int max = -1000000;
		int temp = 0;
		int pos = 0;
		for(int i =0; i< m; i++){
			temp += arr.get(i);
		}
		max = temp;
		
		for(int i = m; i<n; i++){
			temp+=arr.get(i);
			if(n-m > pos){
				temp-=arr.get(pos);
				++pos;
			}
			
			if(max<temp) max = temp;
		}
		
		System.out.println(max);
	}
}
