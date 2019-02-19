import java.util.Scanner;
import java.util.Stack;

public class DP_가장긴최장수열{
	static int[] dp;
	 public static void main(String[] args) {
		solve();
	}
	static private void solve() {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    dp = new int[n];
	    int[] array = new int[n];
	 
	    Pair2[] tracking = new Pair2[n];
	 
	    for (int i = 0; i < n; i++) {
	        array[i] = sc.nextInt();
	    }
	 
	    dp[0] = array[0];
	    tracking[0] = new Pair2(0, array[0]);
	    int idx = 0;
	    for (int i = 1; i < n; i++) {
	        if (dp[idx] < array[i]) {
	            dp[++idx] = array[i];
	 
	            tracking[i] = new Pair2(idx, array[i]);
	        } else {
	            int ii = lower_bound(idx, array[i]);
	            dp[ii] = array[i];
	 
	            tracking[i] = new Pair2(ii, array[i]);
	        }
	    }
	 
	    Stack<Integer> stack = new Stack<Integer>();
	    int temp = idx;
	    for (int i = n - 1; i >= 0; i--) {
	        if (temp == tracking[i].idx) {
	            stack.push(tracking[i].value);
	            --temp;
	        }
	    }
	    System.out.println(stack.size());
	    while(!stack.isEmpty()) {
	        System.out.print(stack.pop() + " ");
	    }
	}
	 
	static int lower_bound(int end, int n) {
	    int start = 0;
	 
	    while (start < end) {
	        int mid = (start + end) / 2;
	        if (dp[mid] >= n) {
	            end = mid;
	        } else {
	            start = mid + 1;
	        }
	    }
	    return end;
	}
	 


}
class Pair2 {
    int idx;
    int value;
 
    Pair2(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}
