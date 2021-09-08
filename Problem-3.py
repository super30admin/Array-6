"""
TC: O(nk)
SC: O(k)
"""
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if k >= len(prices)//2: # optimization
            """
            This is when you do consecutive transactions. The most number of consecutive transactions that you can do is n/2 i.e buy nth day and sell n+1th day consecutively
            """
            result = 0
            for i in range(1, len(prices)):
                if prices[i]> prices[i-1]:
                    result +=  prices[i] - prices[i-1]
            return result
        
        buy = [float('inf')]*(k+1) # actual solution
        profit = [0] * (k+1)
        for i in range(len(prices)):
            for j in range(1, k+1):
                buy[j] = min(buy[j], prices[i] - profit[j-1])
                profit[j] = max(profit[j], prices[i] - buy[j])
        return profit[-1]