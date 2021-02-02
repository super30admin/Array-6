"""
Time Complexity : O(n)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

I need to maintain a minimum value for buying and the maxprofit that i earn. Iterate through and array and calculate both these
values.
"""


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        minp = float('inf')
        mxprofit = 0
        for i in range(len(prices)):
            if prices[i] < minp:
                minp = prices[i]
            elif prices[i]-minp > mxprofit:
                mxprofit = prices[i]-minp
        return mxprofit
