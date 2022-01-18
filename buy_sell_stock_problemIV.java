//T.C. O(N)
//S.C. O(k+1)
//T.C. O(n)
//S.C. O(k+1)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length/2){
            int maxProfit = 0;
            for(int i = 1; i< prices.length; i++){
                if(prices[i] > prices[i-1])
                maxProfit += prices[i]- prices[i-1];
            }
            return maxProfit;
        }
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        
        for(int i = 0; i < k+1; i++)
            buy[i] = Integer.MAX_VALUE;
        
        for(int price: prices){
        for(int key = 1; key < k+1; key++){
            buy[key] = Math.min(buy[key], price - sell[key-1]);
            sell[key] = Math.max(sell[key], price - buy[key]);}
        }
        return sell[k];
    }
}