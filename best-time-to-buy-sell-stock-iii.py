# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(1)

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # Two ssets of variables to track best price to buy and max profit from each of the two transactions
        buy1 = float('inf')
        buy2 = float('inf')
        profit1 = 0
        profit2 = 0

        for price in prices:
            buy1 = min(buy1, price)
            profit1 = max(profit1, price - buy1)
            # Account for the profit of the first transaction by reducing the profit from the price for the second transaction
            buy2 = min(buy2, price - profit1)
            profit2 = max(profit2, price - buy2)

        return profit2
