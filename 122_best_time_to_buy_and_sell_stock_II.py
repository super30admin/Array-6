from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
            Time Complexity - O(n)
            Space Complexity - O(1)
        """
        i = profit = 0
        N = len(prices) - 1
        while i < N:
            # finding the last continuous day that the price is smallest
            while i < N and prices[i + 1] <= prices[i]:
                i += 1
            buy = prices[i]

            # finding the last continuous day that the price is biggest
            while i < N and prices[i + 1] > prices[i]:
                i += 1
            sell = prices[i]

            profit += sell - buy
        return profit
