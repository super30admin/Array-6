"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def maxProfit(self, prices):
        n = len(prices)
        
        currBuy = -prices[0]
        currSell = 0

        for i in range(1, n):
            tempBuy = currBuy
            currBuy = max(currBuy, -prices[i])
            currSell = max(currSell, tempBuy + prices[i]) 

        return currSell