import java.util.Scanner;

public class 이분_달팽이는올라가고싶다 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();//up
		int b = s.nextInt();//down
		int v = s.nextInt();//goal
		
		int cnt = find(a,b,v);
		System.out.println(cnt);
	}
	public static int find(int up, int down, int goal) {
		int l = 0;
		int res = Integer.MAX_VALUE; 
		int r = (goal/(up-down))+1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(goal <= mid * (up-down)+up) {
				res = Math.min(res, mid+1);
				r = mid-1;
			}else {
				l = mid+1;
			}
		}
		
		return res;
	}
}
