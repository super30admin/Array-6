class Solution {
    public int maxProfit(int k, int[] prices) {
        
        //logic remains  same as previous buy sell stock-iii problem
        
        int[]buy = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE); //O(k)
        
        int []sell = new int[k+1];
        
        for(int j = 0;j < prices.length;j++){//o(n)
            for(int i = 1;i <= k;i++){ //O(k)
                buy[i] = Math.min(buy[i], prices[j] - sell[i-1]); // effective price
                sell[i] = Math.max(sell[i], prices[j] - buy[i]);
            }
        }
        return sell[k];
    }
}