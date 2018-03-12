import java.math.BigInteger;
import java.util.*;

public class test {

	public static int sum = 0;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int counter = 0;
        while(counter<t){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            sum = 0;
            
            int[] x = mergesorted(arr, 0, arr.length-1);
            System.out.println(sum);
            counter++;
            
            for(int a:x){
            	System.out.print(a+" ");
            }
        }
	}
	
	public static int[] merge(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];
		int i = 0, k = 0, j = 0;
		while (k < result.length) {
			if (i < one.length && j < two.length) {
				if (one[i] <= two[j]) {
					result[k] = one[i];
					i++;
				} else {
					result[k] = two[j];
					j++;
					sum+=one.length + j - k;
				}
			} else if (j >= two.length) {
				result[k] = one[i];
				i++;
				
			} else if (i >= one.length) {
				result[k] = two[j];
				j++;
				
			}
			k++;
		}
		return result;
	}

	public static int[] mergesorted(int[] three, int lo, int hi) {
		if (lo == hi) {
			int[] rr = new int[1];
			rr[0] = three[lo];
			return rr;
		}

		int mid = (lo + hi) / 2;
		int[] val1 = mergesorted(three, lo, mid);
		int[] val2 = mergesorted(three, mid + 1, hi);

		int[] y = merge(val1, val2);
		return y;
	}
}

