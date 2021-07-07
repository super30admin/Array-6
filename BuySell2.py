'''
Solution:
1.  Only 2 transactions are allowed, and so keep updating the minimum buying price and potential profit at each instant
    with the available minimum buying price at that instant considering one transaction is done.
2.  Also, the second buying price would be removing the first profit amount as we have profit amount more from first
    transaction.

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
        buyingPrice1, buyingPrice2 = float('inf'), float('inf')
        profit1, profit2 = 0, 0

        #   keep updating the potential Buying Price and corresponding Profits at each instant.
        for price in prices:
            buyingPrice1 = min(buyingPrice1, price)
            profit1 = max(profit1, price - buyingPrice1)

            buyingPrice2 = min(buyingPrice2, price - profit1)
            profit2 = max(profit2, price - buyingPrice2)

        #   return the profit.
        return profit2