// Time Compelxity: O(n) single traveersal
// Space Complexity: O(1) Constant time
public class BuyAndSell3 {
    public int maxProfit(int [] prices){
        int firstBuy = Integer.MAX_VALUE; // keep a track of min price for the first buy
        int firstProfit = 0;
        int secondBuy = Integer.MAX_VALUE; // keep a track of min price for second buy
        int secondProfit = 0;

        for( int price : prices){
            firstBuy = Math.min(firstBuy, price);
            firstProfit = Math.max(firstProfit, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstProfit);
            secondProfit = Math.max(secondProfit, price - secondBuy);
        }

        return secondProfit;

    }

    public static void main ( String[] args){
        BuyAndSell3 solution = new BuyAndSell3();
        int [] prices = {3,3,5,0,0,3,1,4};

        int result = solution.maxProfit(prices);
        System.out.println(result);

    }

}
