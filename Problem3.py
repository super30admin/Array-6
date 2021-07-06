
"""
time : o(n*k)
space : o(1)
"""
class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """


        if k >= len(prices) / 2: #if k is greater than half of the length of array
            maxProfit = 0
            for i in range(1, len(prices)):
                if prices[i] > prices[i - 1]:
                    maxProfit += prices[i] - prices[i - 1]
            return maxProfit


        buy = [float("inf") for _ in range(k + 1)]
        sell = [0 for _ in range(k + 1)]
        
        for price in prices:
            for key in range(1, k + 1): #explore all k transactions 
                buy[key] = min(buy[key], price - sell[key - 1])
                sell[key] = max(sell[key], price - buy[key])
                
        return sell[k] 