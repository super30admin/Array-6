"""
Time Complexity: O(n*k)
Space Complexity: O(k)
"""
class Solution:
    def maxProfit(self, k, prices):
        n = len(prices)
        if n == 0:
            return 0

        buy = [prices[0]] * (k + 1)
        sell = [0] * (k + 1)

        for i in range(1, n):
            for j in range(1, k + 1):
                buy[j] = min(buy[j], prices[i] - sell[j - 1])
                sell[j] = max(sell[j], prices[i] - buy[j])

        return sell[k]