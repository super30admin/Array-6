from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if prices == None or len(prices) == 0:
            return 0
        buy = prices[0]
        profit = 0
        for i in range(1,len(prices)):
            buy = min(buy, prices[i])
            profit = max(profit, prices[i] - buy)
        return profit

# Time Complexity: O(n)
# Space Complexity: O(1)