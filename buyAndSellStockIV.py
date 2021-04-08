# Time Complexity : O(NK)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        #need dp arr of k+1
        
        buy = [float('inf') for i in range(k+1)]
        sell = [0 for i in range(k+1)]
        
        for i in range(len(prices)):
            for j in range(1, len(buy)):
                buy[j] = min(buy[j], prices[i] - sell[j-1])
                sell[j] = max(sell[j], prices[i] - buy[j])
        return sell[k]