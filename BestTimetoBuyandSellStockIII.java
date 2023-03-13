// Time Complexity :  O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {

        // int totalProfit = 0;
        // for (int i =0;i<prices.length;i++){
        //     int lProfit = maxProfit(prices, 0, i);
        //     int rProfit = maxProfit(prices, i, prices.length-1);
        //     totalProfit = Math.max(totalProfit, lProfit+rProfit);
        //     //System.out.println("Left "+lProfit+" Right "+rProfit);
        // }
        // return totalProfit;

        int n = prices.length;
        int[] lProfit = new int[n];
        int[] rProfit = new int[n];

        int minPrice= prices[0];
        lProfit[0] = 0;
        int profit = 0;
        for (int i=1;i<n;i++){
            if (prices[i]<minPrice){
                minPrice=prices[i];
            } 
            profit = Math.max(profit, prices[i]-minPrice);
            lProfit[i] = profit;
        }

        int maxPrice= prices[n-1];
        rProfit[n-1] = 0;
        profit = 0;
        for (int i=n-2;i>= 0;i--){
            if (prices[i]>maxPrice){
                maxPrice=prices[i];
            } 
            profit = Math.max(profit, maxPrice-prices[i]);
            rProfit[i] = profit;
        }

        int tProfit = 0;
        for (int i=0;i<n;i++){
            tProfit = Math.max(tProfit, lProfit[i]+rProfit[i]);
        }

        return tProfit;
    }

    private int maxProfit(int[] prices, int start, int end){
        int minPrice= prices[start];
        int profit = 0;
        for (int i=start+1;i<=end;i++){
            if (prices[i]<minPrice){
                minPrice=prices[i];
            } else {
                profit = Math.max(profit, prices[i]-minPrice);
            }
        }
        return profit;
    }
}
