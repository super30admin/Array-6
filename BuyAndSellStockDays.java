// for the same problem of maximising profit bu choosing one day to buy stock and other day to sell stock ,
// return the index of days when the stock should be bought and when it should be sold

// Time Complexity: O(n) because the array is traversed only once
// Space Complexity: O(1) Constant space

public class BuyAndSellStockDays {

    public static int[] maxProfitWithDays(int [] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int minIndex = -1;
        int buyIndex = -1;
        int sellIndex = -1;

        for( int i =0; i < prices.length; i++){
            if( prices[i] < minPrice){
                minPrice = prices[i];
                minIndex = i; // update the minIndex for buying
            }

            int profit = prices[i] - minPrice;
            if(profit > maxProfit){
                maxProfit = profit;
                buyIndex = minIndex; // the stock will be bought at min Index
                sellIndex = i;  // the stock will be sold at the index i when buyindex is min and orifit is max
            }
        }
        return new int[] {buyIndex, sellIndex};
    }

    public static void main (String[] args){

        int [] prices = { 7,1,5,3,6,4} ;

        int [] result = maxProfitWithDays(prices);

        System.out.println("Buy on day : " +" "+result[0] +" "+"Sell on day :" +" " +result[1]);
    }

}
