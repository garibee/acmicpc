import java.util.Scanner;

public class 브루트_분수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		
		int cnt = 1;
		
		if(n==1) System.out.println("1/1");
		else{
			while(true){
				++i;
				cnt += i; // 누적합
				if(cnt>=n) {
					break;
				}				
			}
			
			int target = cnt-n+1;
			if(i%2==0) {
				System.out.println(i+1-target+"/"+target);
			}else {
				System.out.println(target+"/"+ (i+1-target));
			}
		}
	}
}
