import java.util.Arrays;
import java.util.Scanner;

public class 브루트_접미사배열 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String[] strArr = new String[str.length()];
		for(int i =0; i < str.length();i++) {
			strArr[i] = str.substring(i);
		}
		Arrays.sort(strArr);
		for(int i = 0; i < strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
}
