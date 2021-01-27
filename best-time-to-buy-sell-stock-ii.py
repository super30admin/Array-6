# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        # Keep track of the pairs that for an ascending sequence
        # Accumulate the profit by making transactions at every such pair
        for i in range(1, len(prices)):
            if prices[i-1] < prices[i]:
                profit += prices[i] - prices[i-1]

        return profit
