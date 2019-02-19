import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
 
public class BFS_다리만들기 {
 
    static int map[][];
    static int cntMap[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int N;
    
    static void change(int i, int j, int color){
        map[i][j]=color;
        for(int ar=0; ar<4; ar++){
            if(i+dx[ar]>=0 && j+dy[ar]>=0 && i+dx[ar]<N && j+dy[ar]<N){
                if(map[i+dx[ar]][j+dy[ar]]==-1){
                    map[i+dx[ar]][j+dy[ar]]=color;
                    change(i+dx[ar],j+dy[ar],color);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //<=100
        Queue<Pairs> q = new LinkedList<>();
        map = new int[N][N];
        cntMap = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int v = sc.nextInt();
                if(v==1){
                    q.add(new Pairs(i,j,0));
                }
                map[i][j] = -v; 
            }
        }
        
        int color = 1;
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                if(map[i][j]==-1){
                    change(i, j, color);
                    color++;
                }
            }
        
        int min=0;
        while(!q.isEmpty()){
            
        	Pairs now = q.poll();
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX>=0 && nextY>=0
                        && nextX<N && nextY<N){ 
                    if(map[nextX][nextY]==0){ 
                        q.add(new Pairs(nextX, nextY, now.cnt+1)); 
                        map[nextX][nextY]=map[now.x][now.y]; 
                        cntMap[nextX][nextY]=now.cnt+1; 
                    }else if(map[nextX][nextY]!=map[now.x][now.y]){
                        int temp=cntMap[now.x][now.y]+cntMap[nextX][nextY];
                        if(min==0 || (min!=0 && min>temp))
                            min=temp; 
                    }
                }
            }
        }
        System.out.println(min);
    }
}
class Pairs{
    int x,y,cnt;
    Pairs(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

