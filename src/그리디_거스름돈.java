
import java.util.Scanner;

public class 그리디_거스름돈 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		
		int cnt = 0;
		n = 1000-n;
		if(n/500 > 0){
			cnt += n/500;
			n = n%500;
		}
		
		if(n/100 > 0){
			cnt += n/100;
			n = n%100;
		}
		
		if(n/50 > 0){
			cnt += n/50;
			n = n%50;
		}
		
		if(n/10 > 0){
			cnt += n/10;
			n = n%10;
		}
		
		if(n/5 > 0){
			cnt += n/5;
			n = n%5;
		}
		
		if(n/1 > 0){
			cnt += n/1;
			n = n%1;
		}
		
		System.out.println(cnt);
	}
}
