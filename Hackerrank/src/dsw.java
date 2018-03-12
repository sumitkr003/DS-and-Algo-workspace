import java.util.Scanner;

public class dsw {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int testcases = 0;
        while(testcases<t){
            int n = scn.nextInt();
            int arr[] = new int[2*n];
            for(int i =0;i<2*n;i++){
                arr[i] = scn.nextInt();
            }
            int count = 1,temp = 1,l = 0;
            for(int j = 0;j<2*n;j++){
                if(j%2==0){
                    l = j;
                    for(int k = l+3;k<2*n;k+=2){
                        if(arr[l] == arr[k]){
                            temp++;
                            l = k-1;
                        }
                    }
                    if(temp>count){
                        count = temp;
                        temp = 1;
                    }
                }else{
                    l = j;
                    for(int k = l+1;k<2*n;k+=2){
                        if(arr[l] == arr[k]){
                            temp++;
                            l = k+1;
                        }
                    }
                    if(temp>count){
                        count = temp;
                        temp = 1;
                    }
                }
            }
            System.out.println(count);
            testcases++;
        }

	}

}
