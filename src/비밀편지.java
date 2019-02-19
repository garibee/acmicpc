import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 비밀편지{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, String> hm = setHm(new HashMap<String, String>());
		
		int cnt =s.nextInt();
		String str = s.next();
		ArrayList<String> arr = new ArrayList<String>();
		int beginIndex = 0;
		int endIndex = 6;
		for(int i =0; i< cnt;i++) {
			arr.add(str.substring(beginIndex, endIndex));
			beginIndex = endIndex;
			endIndex = beginIndex+6; 
		}
		
		String res = "";
		for(int i =0; i< arr.size();i++) {
			String arrStr = arr.get(i).toString();
			String strr = hm.get(arrStr);
			if(strr==null) {
				boolean check = false;
				String mm = "";
				for(int j =0; j< arrStr.length();j++) {
					String tmp = arrStr;
					String left = tmp.substring(0,j);
					String right = tmp.substring(j+1,tmp.length());
					char t = tmp.charAt(j);
					if(tmp.charAt(j)=='0') 	t = '1';
					else  					t = '0';
					
					mm = left+t+right;
					if(hm.get(mm)!=null) {
						check  = true;
						break;
					}
				}
				if(check==false) {
					System.out.println(i+1);
					return;
				}else {
					res+=hm.get(mm);
				}
			}else {
				res+=hm.get(arrStr);
			}
		}
		System.out.println(res);
	}
	
	public static HashMap<String, String> setHm(HashMap<String, String> hm ) {
		hm.put("000000", "A");
		hm.put("001111", "B");
		hm.put("010011", "C");
		hm.put("011100", "D");
		hm.put("100110", "E");
		hm.put("101001", "F");
		hm.put("110101", "G");
		hm.put("111010", "H");
		
		return hm;
	}
}
