
public class KnapSackwithDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {60,100,120};
		int[] weight = {10,20,30};
		int bag = 50;
		
		System.out.println(withoutdp(price,weight,bag,0,0));
	}
	
	public static int withoutdp(int[] price,int[] weight,int bag,int val,int idx){
		if(idx == weight.length){
			return val;
		}
		
		int v1 = withoutdp(price, weight, bag, val, idx+1);
		int v2 = 0;
		if(bag - weight[idx]>=0){
			v2 = withoutdp(price, weight, bag-weight[idx], val+price[idx], idx+1);
		}
		return Math.max(v1, v2);
	}
	
	public static int withdp(){
		return 0;
	}

}
