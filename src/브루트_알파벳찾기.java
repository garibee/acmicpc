import java.util.Arrays;
import java.util.Scanner;

public class 브루트_알파벳찾기 {
	public static void main(String[] args) {
		char[] alpabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Scanner s = new Scanner(System.in);
		int[] arr = new int[26];
		String str = s.nextLine();
		Arrays.fill(arr, -1);
		for(int i =str.length()-1; i>=0;i--){
			for(int j =0; j< 26; j++){
				if(str.charAt(i)==alpabet[j]){
					arr[j] = i;
					break;
				}
			}
		}
		
		for(int i =0; i < arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
