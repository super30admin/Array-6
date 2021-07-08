"""
// Time Complexity : O(nk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        """
        We replicate the same idea as in case of atmost 2 transactions, but here all k transaction prices will have to be taken into account wrt buy and sell
        
        Edge case - In case of k >= len(prices)/2.
            - Simply compute the running profit for higher adjacent prices and return the running profit that will be maximum
        
        """
        
        if k >= len(prices)//2:
            max_profit = 0
            for i in range(1,len(prices)):
                if prices[i] > prices[i-1]:
                    max_profit += prices[i] - prices[i-1]
            return max_profit
        
        print(len(prices))
        buy = [float("inf")]*(k+1)
        sell = [0]*(k+1)
        
        for price in prices:
            for i in range(1,k+1):
                #buy at any index is effective price at the point - combined profit collected till that point
                buy[i] = min(buy[i],price - sell[i-1])
                
                sell[i] = max(sell[i],price - buy[i])
        return sell[k]