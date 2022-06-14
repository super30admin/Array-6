//Time Complexity O(N)
//Space Complexity O(1) 
//Leetcode tested

public class BestTimeToBuyAndSellStockI {
    public int maxProfit(int[] prices) {
        int max=0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else{
                max = Math.max(max,prices[i] - min);
            }
        }
        return max;
    }    
}
