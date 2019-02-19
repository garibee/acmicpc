import java.util.Scanner;

public class 그리디_기타줄 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] arr = new int[m][2];
		
		int packMin = 1001;
		int min 	= 1001;
		for(int i =0; i < m; i++){
			arr[i][0] = s.nextInt();//��Ʈ
			arr[i][1] = s.nextInt();//����
			packMin = Math.min(packMin, arr[i][0]); // ��Ű���� ���� ������
			min 	= Math.min(min, arr[i][1]); // ������ ���� ���� ��
		}
		check(packMin, min, n);
	}
	
	// ��Ű�� �ݾ�, ���� �ݾ�, ��ǥ����
	public static void check(int packMin, int indiMin, int n) {
		if(packMin<= indiMin) { // ��Ű���� �� ������ ���
			int p = n/6;
			int nmg = n%6;
			if(nmg>0) p++;
			System.out.println(packMin * p);
			
		}else {
			if(packMin> indiMin*6) { // 6�� ���̷� �絵 ������ ���
				System.out.println(indiMin*n);
				return;
			}
						
			int temp = n/6;
			int nmg = n%6;
			System.out.println(
				Math.min(
					packMin*temp+indiMin*nmg, 
					packMin*(temp+1)// �������� ��Ű���� �����Ҷ�, �������� �ִ°��
				)
			);
		}
	}
}

/*
15 2
13 1
5 2
*/