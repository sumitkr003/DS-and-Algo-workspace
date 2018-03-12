

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mazepath(0,0,3,3));
		
		int tax[][] = {{1,2,5,8},{4,1,2,8},{3,7,2,40},{2,0,7,1}};
		System.out.println(mincostpath(3, 3, tax));

	}
	
	public static int mazepath(int sr,int sc,int er,int ec){
		int arr[][] = new int[er+2][ec+2];
		
		 arr[er][ec] = 1;
		
		for(int i = er;i>=0;i--){
			for(int j = ec;j>=0;j--){
				if(i == er || j == ec){
					arr[i][j] = 1;
				}else{
					arr[i][j] = arr[i+1][j] + arr[i][j+1];
				}
				
			}
		}
		return arr[0][0];
	}
	
	public static int mincostpath(int er,int ec,int[][] tax){
		int cost[][] = new int[er+1][ec+1];
		
		for(int i = er;i>=0;i--){
			for(int j = ec;j>=0;j--){
				if(i == er && j == ec){
					cost[i][j] = tax[i][j];
				}else if(i == er){
					cost[i][j] = tax[i][j] + cost[i][j+1];
				}else if(j == ec){
					cost[i][j] = tax[i][j] + cost[i+1][j];
				}else{
					int min = Math.min(cost[i+1][j], cost[i][j+1]);
					cost[i][j] = tax[i][j] + min;
				}
			}
		}
		
		return cost[0][0];
	}
}
