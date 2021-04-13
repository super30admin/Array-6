/*
TC: O(n)
SC:O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        //edge case
        if(prices.length == 0 || prices == null)return 0;
        int minPrice = Integer.MAX_VALUE;
        
        //print the prices
        int price1 = 0;
        int price2 = 0;
        int[]index = new int[2];
        int profit = 0;
        for(int i = 0; i < prices.length;i++){
            
           // minPrice = Math.min(prices[i], minPrice);
           if(minPrice > prices[i]){
               minPrice = prices[i];
               price1 = prices[i]; 
               index[0] = i;
           }
            //price2 = prices[i];
            //profit = Math.max(profit, prices[i]-minPrice);
            if(profit < prices[i]-minPrice){
                profit = prices[i]-minPrice;
                price2 = prices[i];
                index[1] = i;
            }
        }
        
        System.out.println(price1);
        System.out.println(price2);
        System.out.println(Arrays.toString(index));
        return profit;
    }
}