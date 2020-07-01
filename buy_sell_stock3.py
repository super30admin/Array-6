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
        Idea is to see two transactions as the combination of two seperate individual transactions such that effective price till the point is taken to account. 
        """
        buy1,sell1,buy2,sell2 = float("inf"),0,float("inf"),0
        
        for price in prices:
            #minimize the buy price
            buy1 = min(buy1,price)
            
            #maximize the profit for single transaction
            sell1 = max(sell1,price - buy1)
            
            #minimize the effective price using the last maximum profit in single transaction
            buy2 = min(buy2,price - sell1)
            
            #maximize the final profit as cascaded result of both the transactions
            sell2 = max(sell2, price - buy2)
        
        return sell2