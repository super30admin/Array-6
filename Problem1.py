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
        if not prices:
            return 0
        max_p = 0
        min_val = prices[0]
        
        for i in range(len(prices)):
            if prices[i] < min_val: #maintain min val and calculate max profit accordingly
                min_val = prices[i]
            else:
                max_p = max(max_p, prices[i] - min_val)
        return max_p