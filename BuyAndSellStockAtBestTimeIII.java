/*
Time Complexity: O(n), n is the length of prices array
Space Complexity: O(1)
Run on Leetcode: Yes
Any difficulties: No

Approach:
1. maximum profit earned by the one transaction can be re-invested in the second transaction
2. Calculation maximum profit after second transaction
 */
public class BuyAndSellStockAtBestTimeIII {
    public static int maxProfitForAtMostTwoTransactions(int[] prices){
        int minPrice1 = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int minPrice2 = Integer.MAX_VALUE;
        int maxProfit2 = 0;

        for(int price: prices){
            // Maximum profit when one transaction is allowed
            minPrice1 = Math.min(minPrice1, price);
            maxProfit1 = Math.max(maxProfit1, price-minPrice1);

            // Reinvesting the maxProfit1 for the next transaction

            minPrice2 = Math.min(minPrice2, price-maxProfit1);
            maxProfit2 = Math.max(maxProfit2, price-minPrice2);
        }

        // Maximum profit after two transactions
        return maxProfit2;
    }

    public static void main(String[] args){
        System.out.println("Maximum profit after, at most two Transactions: "+
                maxProfitForAtMostTwoTransactions(new int[]{3,3,5,0,0,3,1,4}));
    }
}
