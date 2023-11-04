class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buy = [10*10]*k
        sell = [0]*k
        for i in range(0, len(prices)):
            for j in range(0, k):
                if j >= 1:
                    buy[j] = min(buy[j], prices[i]-sell[j-1])
                else:
                    buy[j] = min(buy[j], prices[i])
                sell[j] = max(sell[j], prices[i] - buy[j])
        return sell[k-1]



        