# Time Complexity : O(K*N)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Use DP where buy[i] and sell[i] represent
# the best profit after i-th transaction.

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices:
            return 0
        
        buy = [float('inf')] * (k+1)
        sell = [0] * (k+1)
        
        for price in prices:
            for i in range(1, k+1):
                buy[i] = min(buy[i], price - sell[i-1])
                sell[i] = max(sell[i], price - buy[i])
        
        return sell[k]