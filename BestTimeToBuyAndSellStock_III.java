//Time Complexity: O(n); where n is length of prices array.
//Space Complexity: O(1)
public class BestTimeToBuyAndSellStock_III { 
	/**Approach: One Pass | Time O(n)**/
	public int maxProfit(int[] prices) {
        int buy1 = prices[0]; int buy2 = prices[0];
        int sell1 = 0; int sell2 = 0;
        for(int i=1; i<prices.length; i++){
        	//for e.g. [3,3,5,0,0,3,1,4]- max profit for first transaction at 5 is 2
        	//For second transaction, reinvest profit gained so far i.e. use 0-2 instead of buying 0
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1); //profit of first transaction
            buy2 = Math.min(buy2, prices[i] - sell1); //reduce the profit of first transaction from current price to consolidate
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		BestTimeToBuyAndSellStock_III ob  = new BestTimeToBuyAndSellStock_III();	
		int[] prices = {3,3,5,0,0,3,1,4};
						
		System.out.println("Max profit achieved from at most two transactions: "+ ob.maxProfit(prices));   
	}	
}
