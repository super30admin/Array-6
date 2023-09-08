"""
Problem : 3

Time Complexity : O(nk)
Space Complexity : O(k)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Buy and Sell Stock at Best Time IV

class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        buy=[float('inf') for _ in range(k+1)]
        sell=[0 for _ in range(k+1)]
    

        for i in range(len(prices)):
            for j in range(1,k+1):
                buy[j]=min(buy[j],prices[i]-sell[j-1])
                sell[j]=max(sell[j],prices[i]-buy[j])

        return sell[k]