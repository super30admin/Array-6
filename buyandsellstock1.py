

"""
## Problem1: Buy and Sell Stock at Best Time (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
"""

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ##on and o1 time and space
        minimum = prices[0]
        maximum = 0
        for i in range(1, len(prices)):
            # maximum=max(maximum, prices[i]-minimum)
            maximum = max(maximum, prices[i] - minimum)
            minimum = min(minimum, prices[i])
        return maximum


