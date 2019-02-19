import java.util.Scanner;

public class 브루트_윷놀이{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] yut = {'E','A','B','C','D'};
		
		for(int i =0; i <3;i++ ) {
			int dung = 0;	
			for(int j =0; j<4;j++) {
				int ret = sc.nextInt();
				if(ret == 0) {
					dung++;
				}
			}
			
			System.out.println(yut[dung]);
		}
	}
}

/*
6
6
10
13
9
8
1
*/