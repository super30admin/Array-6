/*

Did it run on leetcode: Yes
Did you face any problem: no
Time complexity: 0(N)
Space Complexity: 0(1)


Algorithm:
- Traverse the array
- first buy a stock (as you can buy and sell only once)
- The after calculate profit for and update min cost to maximize profit.



*/

class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length==0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int price: prices){
            if(price<min){
                min = price;
            }
            if(profit<price-min){
                profit = price-min;
            }
        }
        
        return profit;
        
    }
}