class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if(len(prices)<=1):
            return 0

        maximum = prices[-1]
        diff = -1*float("inf")

        for i in range(len(prices)-2,-1,-1):
            diff = max(diff, maximum - prices[i])
            maximum = max(maximum, prices[i])

        return max(diff,0)
