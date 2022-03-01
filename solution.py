class Solution:
    def maxProfit3(self, prices: List[int]) -> int:
        buy1 = prices[0]
        sell1 = max(prices[0] - buy1 ,0 )
        buy2 = min(prices[0], prices[0] - sell1)
        sell2 = max(prices[0] - buy2, 0)
        for i in range(1, len(prices)):
            buy1 = min(buy1, prices[i])
            sell1 = max(sell1, prices[i]- buy1)
            buy2 = min(buy2, prices[i] - sell1)
            sell2 = max(sell2, prices[i] - buy2)
        return sell2

    def maxProfit1(self, prices: List[int]) -> int:
        if(not prices):
            return 0
        minimum = prices[0]
        maximum = 0
        for i in range(len(prices)):
            if prices[i] < minimum:
                minimum = prices[i]
            else:
                maximum = max(maximum, prices[i] - minimum)
        return maximum