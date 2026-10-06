# Problem1: Buy and Sell Stock at Best Time (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
# Time Complexity: O(n),We go through the prices array exactly once and each step does only constant work (one min and one max).
# Space Complexity: O(1),We only store two variables, profit and min_val, no matter how large the input is.
# Approach:
# For any selling day, the best buying day is the cheapest price before it. 
#So we walk through the days once, keep track of the lowest price seen so far and at each day check the profit if we sold today. 
#We keep the biggest profit we find.

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # Best profit found so far. Starting at 0 handles the case
        # where prices only go down and no profit is possible.
        profit = 0

        # Number of days, used to loop over every index once.
        n = len(prices)

        # Lowest price seen so far. Infinity makes sure the very
        # first price always replaces it.
        min_val = float('inf')

        for i in range(n):
            # Left to right order means min_val only holds prices
            # from earlier days, so we always buy before we sell.
            min_val = min(min_val, prices[i])

            # Profit if we sell today after buying at the lowest
            # earlier price. Keep it only if it beats our best.
            profit = max(profit, prices[i] - min_val)

        # After checking every day, profit holds the maximum.
        return profit