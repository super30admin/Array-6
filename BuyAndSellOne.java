import javax.print.attribute.standard.PrinterResolution;

// Time Complexity: O(n) because prices array is traversed only once
// Space Complexity: O(1) Constant Space
public class BuyAndSellOne {
    public int buyAndSellStocks(int[] prices ){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;


        for( int i =0; i < prices.length; i++){
            int profit = prices[i] - minPrice;
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else{
                maxProfit = Math.max(maxProfit,profit) ;
            }
        }
        return maxProfit;

    }
    public static void main (String[] args){
        BuyAndSellOne solution = new BuyAndSellOne();

        int [] prices = { 7,1,5,3,6,4} ;
        int result =  solution.buyAndSellStocks(prices);
        System.out.println("Maximum profit acheived" +" " +result);
    }


}
