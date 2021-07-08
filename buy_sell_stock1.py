"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        """
        Brute force - Check for each pair of prices and keep track of 
        the maximum profit and return the max profit (wasteful comparisons)
        Optimal
        - Leveraging the concept of max profit - min cost price and max selling price, so we keep track of the minimum buy value till this point and maximum sell value using the effective buy price. 
        """
        buy,sell = float("inf"),0
        for price in prices:
            buy = min(buy,price)
            sell = max(sell,price - buy)
        return sell