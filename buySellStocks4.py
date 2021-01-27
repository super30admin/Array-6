#Time Complexity : O(nk)
#Space Complexity : O(n+k)
#Did this code successfully run on Leetcode : Yes


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices:
            return 0

        if (k > len(prices)/2):
            maxProfit = 0
            for i in range(1, len(prices)):
                if prices[i] > prices[i-1]:
                    maxProfit += prices[i] - prices[i-1]
            return maxProfit

        buy, sell = [float("inf") for _ in range(len(prices))], [0 for _ in range(k+1)]

        for i in range(len(prices)):
            for j in range(1, k+1):
                buy[j] = min(buy[j], prices[i]-sell[j-1])
                sell[j] = max(sell[j], prices[i]-buy[j])

        return sell[k]
