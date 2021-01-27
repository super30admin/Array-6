# TIME COMPLEXITY: O(n*k) in the worst case
# SPACE COMPLEXITY: O(k*k)

class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        # Edge Case
        if not len(prices):
            return 0

        # The total number of transactions can never exceed n/2
        # if k > n/2, buy low, sell high for every pair of consequetive values that satisfies this condition
        # Same as best time to buy sell ii
        max_profit = 0
        n = len(prices)
        if k >= n / 2:
            for i in range(1, n):
                max_profit += max(prices[i] - prices[i-1], 0)
            return max_profit

        # Same logic as best time to buy sell iii
        # instead of using a pair variables, use two arrays of size k to simulate successive transactions
        buy_i = [float('inf') for _ in range(k+1)]
        profit_i = [0 for _ in range(k+1)]

        for price in prices:
            for i in range(1, k+1):
                buy_i[i] = min(buy_i[i], price - profit_i[i-1])
                profit_i[i] = max(profit_i[i], price - buy_i[i])
        return profit_i[k]
