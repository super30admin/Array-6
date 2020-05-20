'''
Solution:
1.  Only 1 transaction is allowed, and so keep updating the minimum buying price and potential profit at each instant
    with the available minimum buying price at that instant.

Time Complexity:    O(N)
Space Complexity:   O(1)

--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        #   edge case checks
        if (prices == None or len(prices) == 0):
            return 0

        #   initializations
        buyingPrice = float('inf')
        profit = 0

        #   keep updating the potential Buying Price and corresponding Profits at each instant.
        for price in prices:
            buyingPrice = min(buyingPrice, price)
            profit = max(profit, price - buyingPrice)

        #   return the profit.
        return profit