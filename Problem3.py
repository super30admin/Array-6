# Problem3: Buy and Sell Stock at Best Time IV (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
# Time Complexity: O(n * k),The outer loop runs once for each of the n days. For each day, the inner loop runs k times (once per transaction). The work inside is constant (one min and one max).
# Space Complexity: O(k),We only keep two lists, buy and sell, each of size k + 1.We do not store a table for all days.
# Approach:
#   For each transaction number j (1 to k) we track two things:
#     buy[j]  = the lowest "real cost" to start transaction j
#     sell[j] = the best total profit using up to j transactions
#   Real cost = today's price minus the profit already earned from
#   the earlier j-1 transactions. This way, one formula handles all
#   transactions, because earlier profit reduces the cost of the next buy.
#   We walk through the days once, and for each day we update every
#   transaction from 1 to k in order. The answer is sell[k].

class Solution:
    def maxProfit(self, k: int, prices: list[int]) -> int:
        # n is the number of days
        n = len(prices)

        # No days means no profit (safety check)
        if n == 0:
            return 0

        # buy[j] is the lowest real cost found so far to start transaction j
        # We start with prices[0] because on day 0 that is the only price we know
        # We make k + 1 spots: index 0 is a helper, indexes 1 to k are the real transactions
        buy = [prices[0]]*(k+1)

        # sell[j] is the best profit found so far using up to j transactions
        # We start with 0 because nothing is sold yet
        # sell[0] stays 0 forever: "0 transactions means 0 profit"
        # Transaction 1 uses sell[0] as its "earlier profit"
        sell = [0]*(k+1)

        # Start from day 1, because day 0 was used in the setup above
        for i in range(1,n):

            # Update each transaction from 1 to k, in this order
            # Order matters: transaction j needs the fresh sell[j-1] from today
            for j in range(1,k+1):

                # Is today a cheaper way to start transaction j?
                # Real cost today = price today minus profit from the earlier transaction
                # Keep the smaller of the old cost and today's cost
                buy[j]= min(buy[j],prices[i]- sell[j-1])

                # Would selling today earn more than our best so far?
                # Profit if we sell today = price today minus the real cost to buy
                # Keep the bigger of the old best and today's profit
                sell[j]= max(sell[j], prices[i]- buy[j])

        # After all days, sell[k] holds the best profit using up to k transactions
        return sell[k]
        