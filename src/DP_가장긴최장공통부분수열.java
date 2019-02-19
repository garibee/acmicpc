import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DP_가장긴최장공통부분수열{
    static int[] A, B, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        A = new int[a.length() + 1];
        B = new int[b.length() + 1];
        dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            A[i + 1] = a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            B[i + 1] = b.charAt(i);
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
