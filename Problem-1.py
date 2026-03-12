# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Track minimum price so far.
# At each step compute possible profit.

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        min_price = float('inf')
        profit = 0
        
        for p in prices:
            min_price = min(min_price, p)
            profit = max(profit, p - min_price)
        
        return profit