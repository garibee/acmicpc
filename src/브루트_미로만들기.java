
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트_미로만들기 {

	static int N, curDir; 
	static int dx, dy; 
	static int sdx, sdy, edx, edy; 
	static int[][] map = new int[103][103]; 
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1}; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		curDir = 2; 
		
		int mid = 51; 
		dx = dy = sdx = sdy = edx = edy = mid;
		map[dx][dy] = 1;
		if(N == 0)
		{
			System.out.println('.');
		}
		else 
		{
			String cmd = br.readLine();
			int nx=0, ny=0;
			for(int i =0; i<N; i++)
			{
				if(cmd.charAt(i) == 'F')
				{
					nx = dx + dxArr[curDir];
					ny = dy + dyArr[curDir];
					map[nx][ny] = 1;
					dx = nx; dy = ny;
					
					boundary(nx, ny);
				}
				else direction(cmd.charAt(i)); 
			}
			
			for(int i=sdx; i<= edx; i++)
			{
				for(int j=sdy; j<= edy; j++)
				{
					if(map[i][j] == 1) System.out.print('.');
					else System.out.print('#');
				}
				System.out.println();
			}
		}
	}
	public static void direction(char dir)
	{	
		if(dir == 'R')
		{
			curDir = (curDir + 1) % 4;
		}
		else if(dir =='L')
		{
			curDir = ( curDir + 3 ) % 4;
		}
	}
	public static void boundary(int dx, int dy)
	{
		sdx = min(sdx,dx); sdy = min(sdy,dy);
		edx = max(edx,dx); edy = max(edy,dy);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}


/**
5
FRFLF
 */









