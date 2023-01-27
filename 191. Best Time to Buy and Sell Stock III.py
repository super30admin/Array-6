class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1 = prices[0]
        sell1 = min(0, buy1)
        buy2 = min(buy1, prices[0] - sell1)
        sell2 = max(0, prices[0] - buy2)

        # print(buy1, sell1, buy2, sell2)

        for i in range(1, len(prices)):
            buy1 = min(buy1, prices[i])
            sell1 = max(sell1, prices[i] - buy1)
            buy2 = min(buy2, prices[i] - sell1)
            sell2 = max(sell2, prices[i] - buy2)

        return sell2

# Single Transaction
# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
