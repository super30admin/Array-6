# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Track profits for two transactions.

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        buy1 = buy2 = float('inf')
        profit1 = profit2 = 0
        
        for p in prices:
            buy1 = min(buy1, p)
            profit1 = max(profit1, p - buy1)
            
            buy2 = min(buy2, p - profit1)
            profit2 = max(profit2, p - buy2)
        
        return profit2