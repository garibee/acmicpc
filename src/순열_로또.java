import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class 순열_로또 {
    static int n;
    static int[] arr;
    static int[] result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        while (true) {
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            arr = new int[n];
            result = new int[n];
 
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i + 1]);
            }
            DFS(0,0);
            for(int i =0; i < n; i++) {
            	result[i] = 0;
            }
            System.out.println();
        }
 
 
    }
    public static void DFS(int start, int depth){
        if(depth==6){
            print();
        }
        //System.out.println("start = " + start +" depth = "+ depth);
        for(int i=start; i<n; i++){
        result[i] = 1;
        DFS(i+1,depth+1);
        result[i] = 0;
        }
        
    }
    public static void print(){
        for(int i=0; i<n; i++){
            if(result[i]==1)
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
 

