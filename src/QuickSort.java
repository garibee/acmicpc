import java.util.StringTokenizer;

public class QuickSort {
	static StringTokenizer st;
	static int n;
	static String filePath = "C://workspace/acmicpc/src/input.txt";
	
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader(filePath));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		st = new StringTokenizer(br.readLine());
		
		int[] arr = {5,2,34,5,6,2,23,14};
		
		quick(arr,0,arr.length-1);
		for(int i =0; i< arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void quick(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[(left+right)/2];
		while(left<right) {
			while(arr[left]<pivot) left++;
			while(arr[right]>pivot) right--;
			
			if(left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		if(l<right) quick(arr,l,right);
		if(left < r) quick(arr,left,r);
		
	}
	
}
