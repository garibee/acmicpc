import java.util.ArrayList;
import java.util.Scanner;

class Pair {
    int x; 
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class DFS_치킨배달 {
    static int n;
    static int m;
    static int[][] inputAry;
    static ArrayList<Pair> storeList;
    static ArrayList<Pair> personList;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        inputAry = new int[n][n];
        storeList = new ArrayList<Pair>();
        personList = new ArrayList<Pair>();
        ArrayList<Pair> answerList = new ArrayList<Pair>();
	    
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                inputAry[i][j] = sc.nextInt();
                if(inputAry[i][j] == 2) {
                    storeList.add(new Pair(i,j));
                } else if(inputAry[i][j] == 1) {
                    personList.add(new Pair(i,j));
                }
            }
        }
        System.out.println(storeList.size());
        boolean[] check = new boolean[storeList.size()];
	    
        dfs(0,0, answerList, check);
        System.out.println(answer);
    }
    public static void dfs(int start, int depth, ArrayList<Pair> answerList, boolean[] check) {
        if(depth == m) {
            int sum = calAnswer(answerList);
            answer = Math.min(answer, sum);
            return;
        }
        for(int i = start; i < storeList.size(); i++) {
            if(check[i])
                continue;
            check[i] = true;
            answerList.add(storeList.get(i));
            dfs(i+1, depth+1, answerList, check);
            answerList.remove(answerList.size()-1);
            check[i] = false;
        }
    }
	public static int calAnswer(ArrayList<Pair> answerList) {
        int sum = 0;
        for(int i = 0; i < personList.size(); i++) {
            Pair p1 = personList.get(i);
            int len = Integer.MAX_VALUE;
            for(int j = 0; j < answerList.size(); j++) {
                Pair p2 = answerList.get(j);
                int temp = Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
                len = Math.min(len, temp);
            }
            sum += len;
        }
        return sum;
    }
}