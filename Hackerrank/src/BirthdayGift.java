import java.util.Scanner;

public class BirthdayGift {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int[] arr = new int[n];
			int i,j=0,count=0,sum=0;
			for(i=0;i<arr.length;i++){
				arr[i] = in.nextInt();
			}
			int d = in.nextInt();
			int m = in.nextInt();
	        i=0;
			while(true){
	            j=i;
	            while(j<(i+m) && j<arr.length){
	                sum = sum + arr[j];
	                j++;
	            }
	            if(sum==d){
	                count++;
	            }
	            if(j==arr.length){
	                break;
	            }
	            i++;
	            sum =0;
	        }
			System.out.println(count);

	}

}
