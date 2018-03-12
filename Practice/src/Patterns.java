import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
//		pattern1(n);
//		pattern2(n);
		pattern3(n);
		fibonaccipattern(n);
		
	}
	
	public static void pattern1(int row){
		int num = 1;
		int r = 1;
		while(r<=row){
			int x = 0;
			while(x<r){
				System.out.print(num+" ");
				num++;
				x++;
			}
			System.out.println();
			r++;
		}
	}
	
	public static void pattern2(int row){
		int i = 1;
		while(i<=row){
			int j = 0;
			while(j<i){
				if(j == 0){
					System.out.print(i);
				}else if(j == i - 1){
					System.out.print(i);
				}else{
					System.out.print(0);
				}
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public static void pattern3(int n){
		int i = 0,j = 1,row = 0;
		while(row<n){
			int col = 0;
			while(col<=row){
					System.out.print(i+" ");
					int temp = i;
					i = j;
					j+=temp;
				col++;
			}
			System.out.println();
			row++;
		}
	}
	
	public static void fibonaccipattern(int row){
		int first = 0,second = 1;
		
		for(int i = 0;i<row;i++){
			
		}
	}

}
