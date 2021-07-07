'''
Solution:
1.  Only k transactions are allowed, and so keep updating the minimum buying price and potential profit at each instant
    with the available minimum buying price at that instant considering one transaction is done, extending the idea
    from previous two questions.
2.  Also, the kth buying price would be removing the (k-1)th profit amount as we have profit amount more from k-1
    transactions.
3.  If k > n/2 => infinite transactions would be allowed as there can be atmost n/2 transactions, and so for that case
    just keep adding the positive slopes so that we get the maximum profit.

Time Complexity:    O(N * k)
Space Complexity:   O(k)

--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:

        #   edge case checks
        if (prices == None or len(prices) == 0):
            return 0

        #   case where k >= n/2 => infinite transactions => keep adding only positive slopes.
        if (k >= len(prices) / 2):

            profit = 0

            for i in range(1, len(prices)):
                profit += max(0, prices[i] - prices[i - 1])

            return profit

        #   initializations
        buyingPrices = [float('inf') for i in range(k + 1)]
        profits = [0 for i in range(k + 1)]

        #   keep updating the potential Buying Price and corresponding Profits at each instant.
        for price in prices:

            for i in range(k):
                buyingPrices[i] = min(buyingPrices[i], price - profits[i])
                profits[i + 1] = max(profits[i + 1], price - buyingPrices[i])

        #   return the final profit
        return profits[k]