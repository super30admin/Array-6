/*
Time Complexity: O(N), N is the length of prices array
Space Complexity: O(1)
Run on Leetcode: Yes
Any Difficulties: No

Approach:
1. To maximize profit by at the minimum price
2. Maximum profit would be price-minPrice and then return the minimum price
 */
public class BuyAndSellStockAtBestTime {
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price-minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args){
        System.out.println("Maximum Profit one can get: "+ maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
