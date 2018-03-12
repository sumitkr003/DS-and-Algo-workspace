package Lecture2_Recursion;

public class SudukoSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sudoku[][] =  {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
				};
		
		System.out.println("-----------S U D O K U-----------");
		for(int i = 0;i<sudoku.length;i++){
			for(int j =0;j<sudoku[0].length;j++){
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		solver(sudoku,0,0,8,8);
	}
	
	public static void solver(int sudoku[][],int cr,int cc,int er,int ec){
		//sudoku solved
		if(cc == ec && cr == er){
			for(int i = 1;i<=sudoku.length;i++){
				if(check(sudoku,cr,cc,i)){
					sudoku[cr][cc] = i;
				}
			}
			
			System.out.println("--S U D O K U---S 0 L V E D ----");
			for(int i = 0;i<sudoku.length;i++){
				for(int j =0;j<sudoku[0].length;j++){
					System.out.print(sudoku[i][j]+" ");
				}
				System.out.println();
			}
			sudoku[cr][cc] = 0;
			return;
		}
		
		//base case
		if(cr>er || cc>ec){
			return;
		}
		
		if(cc < ec && sudoku[cr][cc]==0){
			for(int i = 1;i<=sudoku.length;i++){
				if(check(sudoku,cr,cc,i)){
					sudoku[cr][cc] = i;
					solver(sudoku,cr,cc+1,er,ec);
					sudoku[cr][cc] = 0;
				}
			}
		}else if(cc == ec && sudoku[cr][cc]==0){
			for(int i = 1;i<=sudoku.length;i++){
				if(check(sudoku,cr,cc,i)){
					sudoku[cr][cc] = i;
					solver(sudoku,cr+1,0,er,ec);
					sudoku[cr][cc] = 0;
				}
			}
		}else{
			if(cc<ec){
				solver(sudoku,cr,cc+1,er,ec);
			}else if(cc == ec){
				solver(sudoku,cr+1,0,er,ec);
			}
		}
	}
	
	public static boolean check(int sudoku[][],int cr,int cc,int num){
		for(int i = 0;i<sudoku[0].length;i++){
			if(sudoku[cr][i] == num){
				return false;
			}
		}
		
		for(int i = 0;i<sudoku.length;i++){
			if(sudoku[i][cc] == num){
				return false;
			}
		}
		
		//sr-starting row of sub matrix
		//er- ending row of sub matrix
		
		int root = 3;
		int sr = (cr/root) * root;
		int sc = (cc/root) * root;
		
		for(int i = sr;i<sr+root;i++){
			for(int j = sc;j<sc+root;j++){
				if(sudoku[i][j] == num){
					return false;
				}
			}
		}
		return true;
	}

}
