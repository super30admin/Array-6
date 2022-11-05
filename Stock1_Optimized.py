# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # we will be finding the min price till the i the index and calculate the profit with respect to the i th price
        min_val = prices[0]
        max_profit = 0
        
        # traverse over the prices array
        for i in range(1,len(prices)):
            # check if the current price is the minmum or not
            min_val = min(min_val, prices[i])
            
            # update the profit with the difference of min and current price
            max_profit = max(max_profit, prices[i] - min_val)
        
        # return the max profit earned
        return max_profit
