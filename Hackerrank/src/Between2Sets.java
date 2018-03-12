import java.util.Scanner;

public class Between2Sets {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}
		int total = getTotalX(a, b);
		System.out.println(total);

	}

	public static int getTotalX(int[] a, int[] b) {
		int min = b[0], max = a[0], i, j, k = 0;
		for (i = 1; i < b.length; i++) {
			if (min > b[i]) {
				min = b[i];
			}
		}
		for (i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		if (min < max) {
			return 0;
		}
		for (i = max; i <= min; i++) {
			for (j = 0; j < a.length; j++) {
				if (i % a[j] != 0) {
					break;
				}
			}
			if (j==a.length){
				for (j = 0; j < b.length; j++) {
					if (b[j] % i != 0) {
						break;
					} else if (j == b.length - 1) {
						k++;
					}
				}
			}
		}
		return k;
	}

}
