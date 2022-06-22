//TC : O(N)
//SC : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        
       for(int i = 1; i< prices.length; i++){
           min = Math.min(min, prices[i]); // Everytime checking min to buy
           max = Math.max(max, prices[i] - min); // checking the maxProfit we can get from buyb price
       }
        
        return max; // returning maxProfit we can get
    }
}

