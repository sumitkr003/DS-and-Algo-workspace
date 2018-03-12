package lecture1_Recursion;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		System.out.println(fib(9));

	}
	
	public static int fib(int n){
		//base case
		if(n==0 || n == 1){
			return n;
		}
		
		int fib = fib(n-2) + fib(n-1);
		
		return fib;
	}

}
