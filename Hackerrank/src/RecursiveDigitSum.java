import java.util.Scanner;

public class RecursiveDigitSum {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        String n = in.next();
	        int k = in.nextInt();
	        int result = superDigit(n);
	        int rem = 0;
	        int num = result;
	        if(result<=9){
	            System.out.println(result);
	        }else{
	            while(num>0){
	               rem =  rem + num%10;
	                num = num/10;
	            }
	            result = rem;
	            System.out.println(result);
	        }
	        in.close();

	}
	static int superDigit(String n) {
        // base case((n/10)<0)
        if(n.length()==1){
            return Integer.parseInt(n);
        }
        int num =  Integer.parseInt(n),rem = 0;
        while(num>0){
            rem+=num%10;
            num = num/10;
        }
        n = String.valueOf(rem);
        return superDigit(n);
    }
}
