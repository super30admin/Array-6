class Solution:
    '''
    Accepted on leetcode(188)
    Time - O(N)
    Space - O(k+1)
    Approach:
    1. If k > half the length of prices array then just check for adjacent elements and return maxProfit
    2. If k < half the length of prices array then follow the approach in previous problem by creating buy and sell arrays and using the formula.
    '''

    def maxProfit(self, k: int, prices) -> int:
        if k >= len(prices) / 2:
            maxProfit = 0
            for i in range(1, len(prices)):
                if prices[i] > prices[i - 1]:
                    maxProfit += prices[i] - prices[i - 1]
            return maxProfit

        buy = [float("inf") for _ in range(k + 1)]
        sell = [0 for _ in range(k + 1)]

        for price in prices:
            for key in range(1, k + 1):
                buy[key] = min(buy[key], price - sell[key - 1])
                sell[key] = max(sell[key], price - buy[key])

        return sell[k]