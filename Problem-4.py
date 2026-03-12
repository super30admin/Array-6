# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Use 3 states:
# hold -> holding stock
# sold -> just sold
# rest -> cooldown/rest

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        hold = -prices[0]
        sold = 0
        rest = 0
        
        for i in range(1, len(prices)):
            
            prev_sold = sold
            
            sold = hold + prices[i]
            hold = max(hold, rest - prices[i])
            rest = max(rest, prev_sold)
        
        return max(sold, rest)