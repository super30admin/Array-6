from typing import List
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buy = [float("inf")]*(k+1)
        sell = [0]*(k+1)
        buy[0] = prices[0]
        for i in range(len(prices)):
            for j in range(1,k+1):
                buy[j] = min(buy[j], prices[i]-sell[j-1])
                sell[j] = max(sell[j], prices[i]-buy[j])         
        return sell[k]


        

        
        