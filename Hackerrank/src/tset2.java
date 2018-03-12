import java.util.Scanner;

public class tset2 {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int q = scn.nextInt();
	        
	        int arr[] = new int[n];
	        for(int i =0;i<n;i++){
	            arr[i] = scn.nextInt();
	        }
	        
	        int sum = 0;
	        while(q>0){
	            int x = scn.nextInt();
	            if(x == 1){
	                int flip = scn.nextInt();
	                if(arr[flip]==0){
	                    arr[flip] = 1;
	                }else{
	                    arr[flip] = 0;
	                }
	            }else if(x == 0){
	                int l = scn.nextInt();
	                int r = scn.nextInt();
	                int j=0;
	                for(int i=r-1;i>=l-1;i--){
	                    sum+=(int)Math.pow(2,j) * arr[i];
	                    j++;
	                }
	            }
	            q--;
	        }
	        
	        if(sum%2==0){
	            System.out.println("EVEN");
	        }else{
	            System.out.println("ODD");
	        }

	}

}
