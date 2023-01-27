class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buy = [float("inf") for i in range(k)]
        sell = [0 for i in range(k)]

        for i in range(len(prices)):
            for j in range(k):
                if j > 0:
                    buy[j] = min(buy[j], prices[i] - sell[j - 1])
                else:
                    buy[j] = min(buy[j], prices[i])

                sell[j] = max(sell[j], prices[i] - buy[j])

        return sell[-1]

# Time Complexity :O(n * k)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

