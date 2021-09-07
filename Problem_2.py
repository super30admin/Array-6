from typing import List
# maximizing profit by combining transactions
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if prices == None or len(prices) == 0:
            return 0
        buy1, buy2 = float('inf'), float('inf')
        sell1, sell2 = 0, 0
        for i in range(len(prices)):
            buy1 = min(buy1, prices[i])
            sell1 = max(sell1, prices[i]- buy1)
            buy2 = min(buy2, prices[i] - sell1)
            sell2 = max(sell2, prices[i] - buy2)
        return sell2

# Time Complexity: O(n)
# Space Complexity: O(1)