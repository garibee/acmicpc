
import java.util.Scanner;
import java.util.Stack;

public class 브루트_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//String[] strList = new String[n];
		
		for(int i =0 ; i < n; i++){
			Stack<Character> stk1 = new Stack<Character>();
			Stack<Character> stk2 = new Stack<Character>();
			boolean test = false;
			String str = sc.next();
			for(int j = 0; j < str.length();j++){
				stk1.push(str.charAt(j));
			}
			
			while(!stk1.isEmpty()){
				char c = stk1.pop();
				if(c==')'){
					stk2.push(c);
				}else{
					if(stk2.isEmpty()){
						test = true;
						break;
					}else{
						stk2.pop();
					}
				}
			}
			
			
			if(!stk1.isEmpty() || !stk2.isEmpty() || test){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}
}
