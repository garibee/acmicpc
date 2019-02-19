import java.util.Scanner;

public class 브루트_벌집 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1 ){
			System.out.println(1);
		}else{
			int six = 6;
			int result = 1;
			int cnt = 1;
			int gop = 0;
			while(true){
				++cnt;
				++gop;
				result = result + (six * gop);
				if(result>=n){
					System.out.println(cnt);
					break;
				}
			}
		}
	}
}
