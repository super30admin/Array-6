# Problem2: Buy and Sell Stock at Best Time III (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
# Time Complexity: O(n),We loop through the prices once and the work inside the loop is constant(two min and two max).
# Space Complexity: O(1),We only use 4 variables (buy1, sell1, buy2, sell2), no matter how big n is.
# Approach:
#   We are allowed at most 2 transactions, so we track 4 numbers:
#     buy1  = lowest price seen so far (best cost to start transaction 1)
#     sell1 = best profit using 1 transaction
#     buy2  = lowest "real cost" to start transaction 2
#             (today's price minus the profit already earned from transaction 1)
#     sell2 = best profit using up to 2 transactions
#   We walk through the days once and update all 4 numbers in this order:
#   buy1, sell1, buy2, sell2. Order matters because each line uses the
#   fresh value from the line above it.
#   The answer is sell2.
#   This is the same idea as the "at most k transactions" solution with k = 2,
#   where the two lists are replaced by single variables.

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # n is the number of days
        n = len(prices)

        # Lowest cost to start transaction 1
        # Start with day 0's price, the only price we know so far
        buy1 = prices[0]

        # Lowest real cost to start transaction 2
        # Also starts at day 0's price, because no profit is earned yet
        buy2 = prices[0]

        # Best profit using 1 transaction, nothing sold yet so 0
        sell1 = 0

        # Best profit using up to 2 transactions, nothing sold yet so 0
        sell2 = 0

        # Visit every day (starting at day 0 is safe, it just keeps the starting values)
        for i in range(n):

            # Is today cheaper than any price we have seen?
            # If yes, it is the best day to start transaction 1
            buy1 = min(buy1, prices[i])

            # If we sell transaction 1 today, we earn price today minus buy1
            # Keep the bigger of the old best and today's profit
            sell1 = max(sell1, prices[i] - buy1)

            # Real cost to start transaction 2 today
            # = today's price minus the profit already earned from transaction 1
            # Keep the smaller of the old cost and today's cost
            # Uses the fresh sell1 from the line above
            buy2 = min(buy2, prices[i] - sell1)

            # If we sell transaction 2 today, total profit is price today minus buy2
            # (buy2 already includes the profit from transaction 1)
            # Keep the bigger of the old best and today's profit
            sell2 = max(sell2, prices[i] - buy2)

        # After all days, sell2 is the best profit with up to 2 transactions
        # If only 1 transaction (or none) is best, sell2 already covers that
        return sell2