

public class Fibonacci {

	public static void main(String[] args) {
		int n = 44;
		long start = System.currentTimeMillis();
		System.out.println(fibrec(n));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		int arr[] = new int[45];
		start = System.currentTimeMillis();
		System.out.println(fibdp(n,arr));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		System.out.println(fibiterative(n));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	
	public static int fibrec(int n){
		if(n == 0|| n == 1){
			return n;
		}
		
		return fibrec(n-1) + fibrec(n-2);
	}
	
	public static int fibdp(int n,int[] arr){
		if(n == 0|| n ==1){
			return n;
		}
		
		if(arr[n]!=0){
			return arr[n];
		}
		
		int fib = fibdp(n-1,arr) + fibdp(n-2,arr);
		arr[n] = fib;
		
		return fib;
	}

	public static int fibiterative(int n){
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2;i<=n;i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}
}
