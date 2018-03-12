package CODE_a_THON;

public class dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int sum = 0;
		for(int i = 1;i<=n;i++){
			for(int j = i;j<=n;j++){
				if(i == j){
					sum+=common(i,j);
				}else{
					sum+= 2 * common(i,j);
				}
			}
		}
		System.out.println(sum);

	}
	
	public static int common(int i,int j){
		int sum = 0;
		if(i == j){
			return i;
		}
		
		if(i==1 || j == 1){
			return 1;
		}
		int l = Math.min(i,j);
		for(int k = 1;k<=l;i++){
			if(i%k == 0 && j%k==0){
				sum+=k;
			}
		}
		
		return sum;
	}

}
