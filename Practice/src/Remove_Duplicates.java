import java.util.Scanner;

public class Remove_Duplicates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		int count = 0;
		while(count<n){
			arr[count] = scn.nextInt();
			count++;
		}
		
//		o(n^2)
		int j;
		for(int i=0;i<n;i++){
			for(j=0;j<i;j++){
				if(arr[i]==arr[j]){
					break;
				}
			}
			if(i==j){
				System.out.println(arr[i]);
			}
		}
	}

}
