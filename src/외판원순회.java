import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 외판원순회{
	public static int n, map[][], d[][], MAX = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int i, j, k;
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		d = new int[n][1<<n];
		String line[];
		
		for(i=0;i<n;i++){
			line = in.readLine().split(" ");
			for(j=k=0;j<line.length;j++)
				if(line[j].length()>0) map[i][k++] = Integer.parseInt(line[j]);
			java.util.Arrays.fill(d[i], MAX); 
		}
		
		out.write(tsp(0, 1)+""); 
		out.close();
		in.close();
	}
	
	private static int tsp(int cur, int visit){
		if(visit == (1<<n)-1) return map[cur][0];
		
		if(d[cur][visit]!=MAX) return d[cur][visit];
		
		for(int i=0;i<n;i++)
			if((visit&(1<<i))==0 && map[cur][i]!=0)
				d[cur][visit] = Math.min(d[cur][visit], map[cur][i]+tsp(i, visit|(1<<i)));
		return d[cur][visit];
	}
}
