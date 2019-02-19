import java.util.*;

public class 이분_공유기설치 {
	static int arr[];
	static int n,c;
    public static boolean isPossible(int mid) {
        int cnt = 1;
        int prevHouse = arr[0];
        for (int house : arr) {
            if (house - prevHouse >= mid) {
                cnt += 1;
                prevHouse = house;
            }
        }
        return cnt >= c;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = 1;
        int l = 1;
        int r = arr[n-1]-arr[0];
        while (l <= r) {
            int mid = (l+r)/2;
            if (isPossible(mid)) {
                ans = Math.max(ans,mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.println(ans);
    }
}