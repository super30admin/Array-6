//Time Complexity: O(n); where n is length of prices array.
//Space Complexity: O(1)
public class BestTimeToBuyAndSellStock {	
	/**Approach: Greedy**/
	public int maxProfit(int[] prices) {   
		int maxProfit=0;
		int min=prices[0];//initial buyday        
        for(int i=1; i<prices.length; i++){   	
        	min = Math.min(min, prices[i]);
        	maxProfit = Math.max(maxProfit, prices[i]-min); 
        }        
        return maxProfit;	
    }

	public static void main (String[] args) {
		BestTimeToBuyAndSellStock ob = new BestTimeToBuyAndSellStock();
		int[] p=new int[] {7,1,5,3,6,4};//{7,6,4,3,1}; {2,4,1}; {3,2,6,5,0,3};
		
		System.out.println("Max profit achieved from one transaction:"+ ob.maxProfit(p));				
	}
}