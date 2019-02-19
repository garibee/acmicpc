import java.util.Scanner;

public class 시험감독 {
	static int n,b,c;
	static int[]students;
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		n = s.nextInt();
		students = new int[n];
		for(int i =0; i< n; i++) {
			int a = s.nextInt();
			students[i] = a;
		}
		
		b = s.nextInt();
		c = s.nextInt();
		long sum = 0;
		for(int i =0; i<n; i++) {
			students[i]-=b;
			++sum;
		}
		for(int i =0; i<n;i++) {
			if(students[i] > 0) {
				sum+= students[i]/c;
				int nmg = students[i]%c;
				if(nmg>0) sum++;
			}
		}
		System.out.println(sum);
	}
}
