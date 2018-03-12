package lecture1_Recursion;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = scn.nextInt();
		}
		
		int low = 0,high = 9;
	    while(low<=high){
	        while(arr[low]%2==0){
	            low++;
	        }
	        while(arr[high]%2!=0){
	            high--;
	        }
	        
	        if(low<=high){
	        	int temp = arr[low];
		        arr[low] = arr[high];
		        arr[high] = temp;
	        }
	    }
	    
	    for(int i = 0;i<10;i++){
	    	System.out.println(arr[i]+" ");
	    }

	}
	
	public static void changearray(int[] arr){
		for(int i = 0;i<arr.length;i++){
			arr[i] = 10;
		}
	}

}
