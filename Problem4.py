# Problem4: Buy and Sell Stock with cooldown https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
# Time Complexity: O(n),There are only n days and 2 states, so n * 2 unique (index, state) pairs. Each pair is solved once and the work per pair is constant (two recursive calls and a max).After that, the memo gives the answer in O(1).
# Space Complexity: O(n),The memo table has n rows and 2 columns, which is 2n cells. The recursion stack can go up to n calls deep (one call per day).
# Approach:
# Each day we are in one of two states: state 0 = we hold no stock, so we can buy and state 1 = we hold stock, so we can sell
# In state 0 we either skip the day, or buy (pay the price, move to state 1). In state 1 we either skip the day, or sell (gain the price, then jump 2 days ahead because of the cooldown, and go back to state 0).
# We try every choice with recursion and take the best profit.
# The same (index, state) repeats many times, so we save each answer in memo and reuse it. This is memoization.

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        n = len(prices)     # n is the number of days, used to size the memo table

        # memo[i][s] stores the best profit from day i onwards when in state s
        # None means "not solved yet"
        # We build a new row for each day so rows do not share the same list
        memo = [[None]*2 for _ in range(n)]

        # Start at day 0 with no stock (state 0)
        return self.helper(prices, 0, 0, memo)

    def helper(self, prices, index, state, memo):
        # Base case: no days left, so no more profit is possible
        # index can also be n + 1 (after a sell on the last day), so we use >=
        if index >= len(prices):
            return 0

        # If this (index, state) was already solved, reuse it
        # We check "is not None" because 0 is a valid saved answer
        if memo[index][state] is not None:
            return memo[index][state]

        if state == 0:
            # We hold no stock, so we can buy
            # Option 1: skip today, stay in state 0, move to the next day
            # Option 2: buy today, so subtract the price, move to state 1 next day
            result = max(
                self.helper(prices, index+1, 0, memo),
                self.helper(prices, index+1, 1, memo) - prices[index]
            )
        else:
            # We hold stock, so we can sell
            # Option 1: keep holding, stay in state 1, move to the next day
            # Option 2: sell today, so add the price, then jump to index + 2
            #           (the skipped day is the cooldown) and go back to state 0
            result = max(
                self.helper(prices, index+1, 1, memo),
                self.helper(prices, index+2, 0, memo) + prices[index]
            )

        # Save the answer so we never compute this (index, state) again
        memo[index][state] = result
        return result