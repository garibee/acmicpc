import java.util.Scanner;

public class 수학_진법변환 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		String str = s.next(); 
		int n = s.nextInt();
		int temp = 0;
		int len = str.length();
		for(int i =0; i<len; i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				temp = temp * n + ( str.charAt(i) - '0');
			}else {
				temp = temp * n + ( str.charAt(i) - 'A' + 10); 
			}
		}
		System.out.println(temp);
	}
}
