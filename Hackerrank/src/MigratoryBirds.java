import java.util.Scanner;

public class MigratoryBirds {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		int i,j;
		for(i=0;i<n;i++){
			arr[i] = scn.nextInt();
		}
		int count,idx=arr[0],max=0;
		for(i=0;i<arr.length;i++){
			count = 0;
			for(j=0;j<arr.length;j++){
				if(arr[j]==arr[i]){
					count++;
					if(count>max){
						idx = arr[i];
						max = count;
					}
					else if(count==max){
						idx = (idx<arr[i]?idx:arr[i]);
						max = count;
					}
					}
				}
		}
		System.out.println(idx);

	}

}
