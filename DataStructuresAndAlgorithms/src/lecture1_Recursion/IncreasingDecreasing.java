package lecture1_Recursion;

public class IncreasingDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		increasing(n,1);

	}
	
	public static void increasing(int n,int i){
		if(i == n){
			System.out.println(n+" ");
			System.out.println("-----------------------------------------------");
			return;
		}
		System.out.print(i+" ");
		
		increasing(n,i+1);
		if(i == n-1){
			System.out.print(n+" ");
		}
		System.out.print(i+" ");
	}

}
