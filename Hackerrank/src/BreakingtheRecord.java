import java.util.Scanner;
public class BreakingtheRecord {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int i;
		for(i=0;i<arr.length;i++){
			 arr[i] = scn.nextInt();
		}
		
		record(arr);

	}
	public static void record(int[] arr){
		int min=arr[0],max=arr[0],j=0,k=0;
		int i;
		for(i=1;i<arr.length;i++){
			if(arr[i]>max){
				j++;
				max=arr[i];
			}
			else if (arr[i]<min){
				k++;
				min = arr[i];
			}
		}
		System.out.println(j+" "+k);
	}

}
