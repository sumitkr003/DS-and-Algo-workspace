import java.util.Scanner;

public class PatternByRecursion {
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		
//		pattern1(row,0,0);
//		*
//		**
//		***
		pattern2(row,0,0);
//		***
//		**
//		*
	}
	
	public static void pattern1(int n,int row,int col){
		if(row == n){
			return;
		}
		if(col<=row){
			System.out.print("*");
			pattern1(n,row,col+1);
			return;
		}
		System.out.println();
		pattern1(n,row+1,0);
	}
	
	public static void pattern2(int n,int row,int col){
		if(row == n){
			return;
		}
		if(col<=row){
			pattern2(n,row,col+1);
			System.out.print("*");
			return;
		}
		pattern2(n,row+1,0);
		System.out.println();
	}
}
