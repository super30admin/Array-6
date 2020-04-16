from typing import List


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        """
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
            Time Complexity - O(n)
            Space Complexity - O(1)
        """
        # min -> buy price, max -> sell price
        min_price = float('inf')
        profit = 0
        for price in prices:
            if price < min_price:
                min_price = price
            else:
                profit = max(profit, price - min_price)
        return profit

    def maxProfit(self, prices: List[int]) -> int:
        """
            Time Complexity - O(n^2)
            Space Complexity - O(1)
        """
        t_max = 0
        for i in range(len(prices)):
            buy = prices[i]
            cur_max = 0
            for j in range(i, len(prices)):
                sell = prices[j]
                if sell > buy and sell - buy > cur_max:
                    cur_max = sell - buy
                    t_max = max(cur_max, t_max)
        return t_max


if __name__ == '__main__':
    Solution().maxProfit([7, 1, 5, 3, 6, 4])
    Solution().maxProfit([7, 2, 5, 3, 16, 4, 1, 10])
