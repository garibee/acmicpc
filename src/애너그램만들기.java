import java.util.Scanner;

public class 애너그램만들기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		//char[] c1 = new char[str1.length()];
		//char[] c2 = new char[str2.length()];
		int[] index1 = new int[27];
		int[] index2 = new int[27];
		
		for(int i=0;i<str1.length();i++) {
			index1[str1.charAt(i)-'a']++;
		}
		for(int i=0;i<str2.length();i++) {
			index2[str2.charAt(i)-'a']++;
		}
		int temp =0;
		for(int i =0;i<26;i++)
			temp+=Math.abs(index1[i]-index2[i]);
		System.out.println(temp);
	}
}
