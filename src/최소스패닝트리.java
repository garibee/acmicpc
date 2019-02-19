import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리 { // 공부할것
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        Node[] nodeList = new Node[M];
        int weightOfCost=0;

        for (int i = 1; i <=N ; i++)
            parent[i]=i;

        for (int i = 0; i <M ; i++) {
            st = new StringTokenizer(br.readLine());
            nodeList[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodeList, Comparator.comparingInt(Node -> Node.cost));

        for (int i = 0; i <M;i++){
            int rootX = findRoot(nodeList[i].start);
            int rootY = findRoot(nodeList[i].end);

            if (rootX == rootY)
                continue;
            else{  
                parent[rootX] = rootY;
                weightOfCost += nodeList[i].cost;  
            }
        }
        System.out.println(weightOfCost);
    }


    private static int findRoot(int u) {
        if (u ==parent[u])
            return u;
        else {
            parent[u] = findRoot(parent[u]);   
            return parent[u];
        }
    }

    private static class Node{
        int start;
        int end;
        int cost;

        private Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}