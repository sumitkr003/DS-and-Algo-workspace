package DP;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdddg";
		String str2 = "abcddefg";
		System.out.println(findLCS(str1,str2));

	}
	
	public static String findLCS(String str1,String str2){
		int arr[][] = new int[str1.length()+1][str2.length()+1];
		String ans="";
		boolean b = false;
		
		for(int i = 0;i<str1.length();i++){
			char ch1 = str1.charAt(i);
			
			for(int j = 0;j<str2.length();j++){
				char ch2 = str2.charAt(j);
				if(i == 0 || j==0){
					if(ch1 == ch2 && !b){
						arr[i][j] = 1;
						ans+=ch1;
						b = true;
					}else if(i == 0 && j == 0){
						arr[i][j] = 0;
					}else if(i == 0){
						arr[i][j] = arr[i][j-1];
					}else{
						arr[i][j] = arr[i-1][j];
					}
				}else if(ch1 == ch2 && !b){
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]) + 1;
					ans+=ch1;
					b = true;
				}else{
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
			b= false;
		}
		
		System.out.println(arr[str1.length()-1][str2.length()-1]);
		return ans;
	}

}