# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # sell the stock before you buy again(and atmost 2 transactions)
        buy1 = float('inf')
        sell1 = 0

        buy2 = float('inf')
        sell2 = 0

        for price in prices:
            # the maximum profit if only one transaction is allowed
            buy1 = min(buy1, price)
            sell1 = max(sell1, price - buy1)

            # reinvest the gained profit in the second transaction
            buy2 = min(buy2, price - sell1)
            sell2 = max(sell2, price - buy2)

        return sell2
