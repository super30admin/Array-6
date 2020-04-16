from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
            Time Complexity - O(n)
            Space Complexity - O(n)
        """
        # edge prices
        if not prices:
            return 0

        k = 2
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


if __name__ == '__main__':
    print(Solution().maxProfit([5, 11, 3, 50, 60, 90]))
