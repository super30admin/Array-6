from typing import List
# recursive solution gives time limit exceeded
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if prices == None or len(prices) == 0:
            return 0
        return self.helper(prices, 0, -1, 0)
    
    def helper(self,prices: List[int], index: int, prevBuy: int, profit: int) -> int:
        # base case
        if index >= len(prices):
            return profit
        
        if prevBuy == -1:
            return max(self.helper(prices, index+1, -1, profit),    # not buy
                       self.helper(prices, index+1, prices[index], profit)   # buy
                      )
        else:
            return max(self.helper(prices, index+1, prevBuy, profit), # not sell
                       self.helper(prices, index+2, -1, profit + prices[index] - prevBuy) # sell
                      )
        
# Time Complexity: Exponential

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if prices == None or len(prices) == 0 or len(prices) < 2:
            return 0
        buy = [0] * len(prices)
        sell = [0] * len(prices)
        buy[0] = -prices[0]
        buy[1] = max(buy[0], 0 - prices[1])
        sell[1] = max(0, buy[0] + prices[1])
        
        for i in range(2, len(prices)):
            buy[i] = max(buy[i-1], sell[i-2] -prices[i])
            sell[i] = max(sell[i-1], buy[i-1] + prices[i])
        return max(buy[len(prices)-1], sell[len(prices)-1])

# Time Complexity: O(n)
# Space Complexity: O(n)