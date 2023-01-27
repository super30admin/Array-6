class Solution:
    def maxProfit(self, prices):
        n = len(prices)
        if n < 2:
            return 0
        buy = [None for i in range(n)]
        sell = [None for i in range(n)]

        buy[0] = -prices[0]
        sell[0] = 0
        buy[1] = max(buy[0], -prices[1])
        sell[1] = max(sell[0], prices[1] + buy[0])

        for i in range(2, n):
            buy[i] = max(buy[i - 1], sell[i - 2] - prices[i])
            sell[i] = max(sell[i - 1], buy[i - 1] + prices[i])
        print(sell[-1])
        return sell[-1]


prices = [48, 12, 60, 93, 97, 42, 25, 64, 17, 56, 85, 93, 9, 48, 52, 42, 58, 85, 81, 84, 69, 36, 1, 54, 23, 15, 72, 15,
          11, 94]

if __name__ == "__main__":
    obj = Solution()
    obj.maxProfit(prices)

# Dynamic Programming
# Using DP Array
# Time Complexity: O(n)
# Space Complexity: O(n)
