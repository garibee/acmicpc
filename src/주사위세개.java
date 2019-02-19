

import java.util.Scanner;

public class 주사위세개{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		int coin = 0;
		if(a==b && b==c){
			coin = 10000+a*1000;
		}else if(a!=b && b!=c && a!=c){
			coin = Math.max(a, Math.max(b,c))*100;
		}else{
			if(a==b || a==c) coin = 1000+a*100;
			else coin = 1000+b*100;
		}
		System.out.println(coin);
	}

}
