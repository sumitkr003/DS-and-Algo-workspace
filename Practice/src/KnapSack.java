
public class KnapSack {

	public static void main(String[] args) {
		int[] price = {60,100,120};
		int[] weight = {10,20,30};
		int bag = 50;
		
		System.out.println(knapsack(price,weight,bag,0,0,0));
	}
	
	public static int knapsack(int[] price,int[] weight,int bag,int wsf,int vsf,int idx){
		if(wsf>bag){
			return 0;
		}
		
		if(idx == weight.length){
			return vsf;
		}
		
		if(wsf == bag){
			return vsf;
		}
		
		int v1 = knapsack(price, weight, bag, wsf, vsf, idx+1); //item not selected
		
		int v2 = knapsack(price,weight,bag,wsf+weight[idx],vsf+price[idx],idx+1); //item selected
		
		return(Math.max(v1, v2));
		
	}

}
