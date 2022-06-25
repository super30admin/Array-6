import java.util.Arrays;
//Time Complexity: O(n); where n is length of prices array.
//Space Complexity: O(1)
public class BestTimeToBuyAndSellStock_IV { 
	/**Approach: One Pass**/
	public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for(int i=0; i<prices.length; i++){
            for(int j=1; j<=k; j++){
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }            
        }
        return sell[k];
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		BestTimeToBuyAndSellStock_IV ob  = new BestTimeToBuyAndSellStock_IV();	
		int k=2;
		int[] prices = {3,2,6,5,0,3};
						
		System.out.println("Max profit achieved from at most k transactions: "+ ob.maxProfit(k, prices));   
	}	
}
