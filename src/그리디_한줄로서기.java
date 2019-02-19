import java.util.Arrays;
import java.util.Scanner;

public class 그리디_한줄로서기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr=  new int[n+1];
		int[] cache=  new int[n+1];
		Arrays.fill(cache, -1);
		for(int i =1; i<=n; i++) {
			arr[i] = s.nextInt(); // ���ʿ� ū ���� ����
		}
		//
		for(int i =1; i<= n; i++) {
			int cnt = 0;
			for(int j =1; j<= n; j++) {
				if(cnt >=arr[i] && cache[j] == -1) {
					cache[j] = i;
					break;
				}
					
				if(arr[i] == 0 && cache[j] == -1) {
					cache[j] = i;
					break;
				}
				
				if(cache[j]==-1)++cnt;
			}
		}
		
		for(int i =1; i< n+1;i++) {
			System.out.print(cache[i]+" ");
		}
	}
}
