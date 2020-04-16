from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        """
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
            Time Complexity - O(nk)
            'n' is the list of stock prices at a given day
            'k' is the no. of transactions
            Space Complexity - O(nk)
        """
        # edge prices
        if not prices:
            return 0

        # if the no of transactions is more than half the length of the list
        if k >= len(prices) // 2:
            return self._multiple_transactions(prices)

        # this takes for day 0 and k
        # profits[0, day] = 0; 0 transactions makes 0 profit
        # profits[transaction, 0] = 0; if there is only one price data point you can't make any transaction.
        # we cannot sell since we haven't bought any stock
        profits = [[0 for day in prices] for transaction in range(k + 1)]

        # t -> transaction
        # d-> day
        for t in range(1, k + 1):
            # store max between 0 and d
            max_thus_far = float('-inf')
            for d in range(1, len(prices)):
                # profit we had prev day with one less transaction  -  buying a stock on the prev day
                max_thus_far = max(max_thus_far, profits[t - 1][d - 1] - prices[d - 1])
                # Not selling anything or selling the stock with prev max,
                # (which includes the buy of the stock profit we made from the prev transaction)
                profits[t][d] = max(profits[t][d - 1], prices[d] + max_thus_far)
        return profits[-1][-1]

    def maxProfit(self, k: int, prices: List[int]) -> int:
        """
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
            Time Complexity - O(nk)
            'n' is the list of stock prices at a given day
            'k' is the no. of transactions
            Space Complexity - O(n)
        """
        # edge prices
        if not prices:
            return 0

        # if the no of transactions is more than half the length of the list
        if k >= len(prices) // 2:
            return self._multiple_transactions(prices)

        # even profits
        even_profits = [0 for d in prices]
        odd_profits = [0 for d in prices]
        for t in range(1, k + 1):
            max_thus_far = float('-inf')
            # even transaction
            if t % 2 == 0:
                current_profits = even_profits
                prev_profits = odd_profits
            else:  # odd transaction
                current_profits = odd_profits
                prev_profits = even_profits

            for d in range(1, len(prices)):
                max_thus_far = max(max_thus_far, prev_profits[d - 1] - prices[d - 1])
                current_profits[d] = max(current_profits[d - 1], prices[d] + max_thus_far)

        return even_profits[-1] if k % 2 == 0 else odd_profits[-1]

    def _multiple_transactions(self, prices: List[int]):
        i = profit = 0
        N = len(prices) - 1
        while i < N:
            # finding the last continuous day that the price is smallest
            while i < N and prices[i + 1] <= prices[i]:
                i += 1
            buy = prices[i]

            # finding the last continuous day that the price is biggest
            while i < N and prices[i + 1] > prices[i]:
                i += 1
            sell = prices[i]

            profit += sell - buy
        return profit


if __name__ == '__main__':
    print(Solution().maxProfit(2, [5, 11, 3, 50, 60, 90]))
