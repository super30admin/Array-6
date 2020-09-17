"""
time : o(n)
space : o(1)
"""
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buy1 = buy2 = prices[0]
        sell1 = sell2 = 0
        
        for i in prices:
            buy1 = min(buy1, i)
            sell1 = max(sell1, i - buy1)
            
            buy2 = min(buy2, i - sell1) #effective price
            sell2 = max(sell2, i - buy2) #will have combined selling price
               
        return sell2
        
        