package lecture1_Recursion;

public class Nqueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int chess[][] = new int[n][n];
		
		nqueens(chess,0,0,n-1,n-1,0);

	}
	
	//qpsf-queen placed so far
	public static void nqueens(int chess[][],int cr,int cc,int er,int ec,int qpsf){
		if(qpsf == chess.length){
			
			System.out.println("------------------");
			for(int i=0;i<chess.length;i++){
				for(int j =0;j<chess[0].length;j++){
					System.out.print(chess[i][j]+" ");
				}
				System.out.println();
			}
			
			return;
		}
		if(cr>er || cc>ec){
			return;
		}
		
		if(isqueensafe(chess,cr,cc)){
			chess[cr][cc] = 1;
			nqueens(chess,cr+1,0,er,ec,qpsf+1);
			chess[cr][cc] = 0;
		}
		
		nqueens(chess,cr,cc+1,er,ec,qpsf);
		
	}
	
	public static boolean isqueensafe(int chess[][],int cr,int cc){
		int row = cr,col = cc;
		while(row>=0){
			if(chess[row][col] == 1){
				return false;
			}
			row--;
		}
		row = cr;
		
		while(row>=0 && col>=0){
			if(chess[row][col] == 1){
				return false;
			}
			row--;
			col--;
		}
		row=cr;
		col=cc;
		
		while(row>=0 && col<chess[0].length){
			if(chess[row][col] == 1){
				return false;
			}
			row--;
			col++;
		}
		row=cr;
		col=cc;
		
//		int i = 0;
//		while(i<chess[0].length){
//			if(chess[row][i] == 1){
//				return false;
//			}
//			i++;
//		}
		
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
