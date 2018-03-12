package lecture1_Recursion;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11,22,55,44,77,66};
		mergesort(arr,0,arr.length - 1);
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void mergesort(int arr[],int left,int right){
		//base case
		if(left == right){
			return;
		}
		
		int mid = (left+right)/2;
		
		mergesort(arr,left,mid);
		mergesort(arr,mid+1,right);
		
		merge(arr,left,mid,right);
		
	}
	
	public static void merge(int arr[],int left,int mid,int right){
		int newarr[] = new int[right -left + 1];
		int i = left,j = mid+1,idx = 0;
		
		while(i<=mid && j<=right){
			if(arr[i]<arr[j]){
				newarr[idx] = arr[i];
				i++;
			}else{
				newarr[idx] = arr[j];
				j++;
			}
			
			idx++;
		}
		
		while(i<=mid){
			newarr[idx] = arr[i];
			i++;
			idx++;
		}
		
		while(j<=right){
			newarr[idx] = arr[j];
			j++;
			idx++;
		}
		
		i = 0;
		for(int k = left;k<=right;k++,i++){
			arr[k] = newarr[i];
		}
	}

}
