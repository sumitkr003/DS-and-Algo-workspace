package CODE_a_THON;

import java.util.Scanner;

public class N_Kings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[]= {1,1,0,0,2,14,90,646,5242,47622,479306,5296790,63779034};
		System.out.println(nkings(0,n,0,0,n-1,n-1,new int[n][n]));
	}
	
	public static int nkings(int kpsf,int n,int cr,int cc,int er,int ec,int arr[][]){
		if(kpsf == n){
			return 1;
		}
		
		if(cr > er || cc > ec){
			return 0; 
		}
		
		int s = 0;
		if(iskingsafe(arr,cr,cc)){
			arr[cr][cc] = 1;
			s+= nkings(kpsf+1,n,cr+1,0,er,ec,arr);
			arr[cr][cc] = 0;
		}
			s+=nkings(kpsf,n,cr,cc+1,er,ec,arr);
		

		
		return s;
		
	}
	
	public static boolean iskingsafe(int arr[][],int cr,int cc){
		int row = cr-1,col = cc;
		boolean b=true;
		if(row>=0){
			while(row>=0){
				if(arr[row][col] == 1){
					return false;
				}
				row--;
			}
			
			row = cr-1;
			col = cc-1;
			
			if(col<0){
				col++;
				b = false;
			}
			
			if(arr[row][col] == 1){
				return false;
			}
			
			if(col+1<arr[0].length  && arr[row][col+1] == 1){
				return false;
			}
			
			if(b && col+2<arr[0].length && arr[row][col+2] == 1){
				return false;
			}
			
		}
		return true;
	}

}
