

public class boardpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 28;
		long start = System.currentTimeMillis();
		System.out.println(countpath(n,0));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
		start = System.currentTimeMillis();
		System.out.println(countpathDP(n,new int[n+1],0));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		System.out.println(countpathiterative(n));
		end = System.currentTimeMillis();
		System.out.println(end - start);

	}
	
	public static int countpath(int n,int sum){
		if(sum>n){
			return 0;
		}else if(sum == n){
			return 1;
		}
		
		int path = 0;
		for(int i = 1;i<7;i++){
			 path+= countpath(n,sum+i);
		}
		
		return path;
	}
	
	public static int countpathDP(int n,int[] arr,int sum){
		if(sum>n){
			return 0;
		}else if(sum == n){
			return 1;
		}
		
		if(arr[sum] != 0){
			return arr[sum];
		}
		
		int path = 0;
		for(int i = 1;i<7;i++){
			 path+= countpathDP(n,arr,sum+i);
		}
		arr[sum] = path;
		return path;
		
	}
	
	public static int countpathiterative(int n){
		int[] arr = new int[n+6];
		
		arr[n] = 1;
		
		for(int i = n-1;i>=0;i--){
			arr[i] = arr[i+1] + arr[i+2] + arr[i+3] + arr[i+4] + arr[i+5] + arr[i+6];
		}
		
		return arr[0];
	}

}
