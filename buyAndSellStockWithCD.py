# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) < 2:
            return 0 
        if not prices:
            return 0
        
        buy = [0 for i in range(len(prices))]
        sell = [0 for i in range(len(prices))]
        #cases
        buy[0] = -prices[0]
        buy[1] = max(buy[0], 0 - prices[1])
        sell[1] = max(sell[0], prices[1] + buy[0])
        
        for i in range(2, len(prices)):
            buy[i] = max(buy[i-1], sell[i-2] - prices[i])
            sell[i] = max(sell[i-1], prices[i] + buy[i-1])
            
        return sell[-1]