# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0 
        
        
        buy1 = float('inf')
        sell1 = 0
        buy2 = float('inf')
        sell2 = 0
        
        for i in range(len(prices)):
            #best one transaction
            buy1 = min(buy1, prices[i])
            sell1 = max(sell1, prices[i] - buy1)
            #transaction of one and two
            buy2 = min(buy2, prices[i] - sell1)
            sell2 = max(sell2, prices[i]- buy2)
        
        return sell2