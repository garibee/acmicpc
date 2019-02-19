import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 그리디_로프 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		int max = 0;
		for(int i =0; i< n; i++){
			arr.add(s.nextInt());
//			max += arr.get(i);
		}

		Collections.sort(arr);

		for(int i = 0; i<n; i++){
			if(max < (arr.get(i)*(n-i) )){
				max = (arr.get(i)*(n-i));
				System.out.println(max);				
			}

		}
		System.out.println(max);
	}
}