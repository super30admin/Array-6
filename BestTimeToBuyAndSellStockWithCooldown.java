//Time Complexity: O(n); where n is length of prices array.
//Space Complexity: O(n)
public class BestTimeToBuyAndSellStockWithCooldown {
	/**Approach2: DP array**/	
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;        
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];       
        buy[1] = Math.max(buy[0], 0-prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for(int i=2; i<n; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return Math.max(buy[n-1], sell[n-1]);
    }
	
	/**Approach1: Brute force + Recursion| Time O(2^n) | Space O(n); where n is length of input array**/	
	/*public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        return helper(prices, 0, -1, 0);        
    }
    private int helper(int[] prices, int i, int prevBuy, int profit){
        //base
        if(i >= prices.length) return profit;
        
        //logic 
        //Not choose case i.e. if previously not bought
        if(prevBuy == -1){
            //case1, buy 
            int case1 = helper(prices, i+1, prices[i], profit);
            //case2, not buy
            int case2 = helper(prices, i+1, -1, profit);            
            return Math.max(case1, case2);                
        }else{ //choose case i.e. previousylt bough so in sell state now
            //case1, sell 
            int case1 = helper(prices, i+2, -1, profit + prices[i] - prevBuy);
            //case2, not sell
            int case2 = helper(prices, i+1, prevBuy, profit);            
            return Math.max(case1, case2);
        }
    }*/
		
	/** Driver code to test above **/
	public static void main (String[] args) {			
		BestTimeToBuyAndSellStockWithCooldown ob  = new BestTimeToBuyAndSellStockWithCooldown();
		int[] prices = {7,10,9,8,1,2,6};//{1,2,3,0,2};
								
		System.out.println("Max profit after buying and selling stocks with cooldown period of one day is: "+ob.maxProfit(prices)); 
	}	
}
