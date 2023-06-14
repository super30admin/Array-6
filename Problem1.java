class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int min = prices[0]; 
       if(n == 0 || prices == null)
            return 0;
       int max = 0;
       for(int i = 0; i < n; i++){
           min = Math.min(min, prices[i]);
           max = Math.max(max, prices[i] - min);
       }
       return max;
    }
}
