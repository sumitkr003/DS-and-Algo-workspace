
public class MCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200};
		int storage[][] = new int[arr.length-1][arr.length];
		System.out.println(mcmRecursion(arr,0,arr.length-1,storage));
		System.out.println(findcost(arr));

	}
	
	public static int mcmRecursion(int[] arr,int si,int ei,int storage[][]){
		if(ei-si<=1){
			return 0;
		}
		if(storage[si][ei]!=0){
			return storage[si][ei];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=si+1;i<ei;i++){
			int count = mcmRecursion(arr, si, i,storage) + mcmRecursion(arr,i,ei,storage);
			count+= arr[si]*arr[i]*arr[ei];
			
			if(count<min){
				min = count;
			}
		}
		
		storage[si][ei] = min;
		
		return min;
	}
	
	public static int findcost(int[] arr){
		 int temp[][] = new int[arr.length][arr.length];
	        int q = 0;
	        for(int l=2; l < arr.length; l++){
	            for(int i=0; i < arr.length - l; i++){
	                int j = i + l;
	                temp[i][j] = 1000000;
	                for(int k=i+1; k < j; k++){
	                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
	                    if(q < temp[i][j]){
	                        temp[i][j] = q;
	                    }
	                }
	            }
	        }
	        return temp[0][arr.length-1];
	}

}
