package Lecture2_Recursion;

public class RatInAMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = {{0,0,0,0,1,1},
				       {0,0,1,1,0,1},
				       {1,0,0,0,1,0},
				       {0,0,1,0,0,0}
		};
		
		int path[][] = new int[maze.length][maze[0].length];
		
		System.out.println("------------M A Z E-----------");
		for(int i=0;i<maze.length;i++){
			for(int j =0;j<maze[0].length;j++){
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		
		
		printpaths(maze,0,0,3,5,path);

	}
	
	public static void printpaths(int maze[][],int cr,int cc,int er,int ec,int[][] path){
		if(cc == ec && cr == er){
			
			System.out.println("------------P A T H-----------");
			for(int i=0;i<maze.length;i++){
				for(int j =0;j<maze[0].length;j++){
					System.out.print(path[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("------------------------------");
			
			return;
		}else if(cc>ec || cr>er){
			return;
		}
		
		path[cr][cc] = 1;
		if(cc+1<=ec && cr<= er && maze[cr][cc+1]!=1){
			path[cr][cc+1] = 1;
			printpaths(maze,cr,cc+1,er,ec,path);
			path[cr][cc+1] = 0;
		}
		
		
		if(cr+1<=er && cc<=ec && maze[cr+1][cc]!=1){
			path[cr+1][cc] = 1;
			printpaths(maze,cr+1,cc,er,ec,path);
			path[cr+1][cc] = 0;
		}
		path[cr][cc] = 0;
	}

}
