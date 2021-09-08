"""
TC: O(n)
SC: O(1)
"""
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1 = float('inf')
        buy2 = float('inf')
        profit1 = 0
        profit2 = 0
        for i in range(len(prices)):
            buy1 = min(buy1, prices[i])
            profit1 = max(profit1, prices[i] - buy1)
            buy2 = min(buy2, prices[i] - profit1)
            profit2 = max(profit2, prices[i] - buy2)
        return profit2