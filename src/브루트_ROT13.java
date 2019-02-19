import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 브루트_ROT13 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();	
		char[] ch = new char[str.length()];
		
		for(int i =0; i< str.length();i++) {
			ch[i] = str.charAt(i);
			if(isNumeric(ch[i]) || ch[i]==' ') {
				continue;
			}else {
				int cnt = 0;
				while(cnt<13) {
					++ch[i];
					++cnt;
					if(ch[i]=='z'+1) {
						ch[i] = 'a';
					}
					if(ch[i]=='Z'+1) {
						ch[i] = 'A';
					}
				}
			}
		}
		//a == 97
		//z == 122
		//A == 65
		//Z == 90

		for(int i =0; i< ch.length;i++) {
			System.out.print(ch[i]);
		}
	}
	public static boolean isNumeric(char ch) {
		boolean b;
		try {
			int i = Integer.parseInt(ch+"");
			b = true;
		}catch(Exception e) {
			b = false;
		}
		return b;
	}
}
