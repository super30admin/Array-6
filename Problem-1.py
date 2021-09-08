"""
TC: O(n)
SC: O(1)
"""
class Solution(object):
    def maxProfit(self, nums):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return 0
        max_profit = 0
        min_price = float('inf')
        
        for curr_price in nums:
            min_price = min(curr_price,min_price)
            curr_profit = curr_price-min_price
            max_profit = max(max_profit,curr_profit)
        return max_profit