"""

## Problem 188: Best Time to Buy and Sell Stock IV

## Author: Neha Doiphode
## Date:   11-24-2022

## Description
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
    Find the maximum profit you can achieve. You may complete at most k transactions.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

## Examples:
    Example 1:
        Input: k = 2, prices = [2,4,1]
        Output: 2
        Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

    Example 2:
        Input: k = 2, prices = [3,2,6,5,0,3]
        Output: 7
        Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
        Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

## Constraints:
    1 <= k <= 100
    1 <= prices.length <= 1000
    0 <= prices[i] <= 1000

## Time complexity: O(n * k), where  n is the length of prices array and
                              k is maximum number of transactions we are allowed to make.

## Space complexity: O(k), auxiliary arrays of length k are required to store
                           the buying and selling prices of previous transactions
                           so that previous profits can be invested into the next transaction.

"""

from typing import List, Optional

def get_input():
    print("Enter array of integers(with spaces): ", end = "")
    array = input()
    array = [int(inp) for inp in array.split()]

    print("Enter integer k(number of transactions you can perform at the most): ", end = "")
    k = int(input())

    return array, k

class Solution:
    def maxProfit_IV(self, k: int, prices: List[int]) -> int:
        """
        This problem is similar to buy and sell stock III.

        The only difference is that, in the previous version,
        the condition was to make at the most 2 transactions.

        Here, we are expected to make k transactions and k can be anything between 1 to 100.

        So we need to store min cost and max_profits of previous transactions in an array
        to make them available for the current transaction.
        """
        min_costs = [float("inf") for _ in range(k)]
        max_profits = [0 for _ in range(k)]

        for index, current_price in enumerate(prices):
            for transaction in range(k):
                if transaction > 0:
                    # from transaction 1, start investing profit made in the previous transaction
                    # into the next transaction.
                    min_costs[transaction] = min(min_costs[transaction], current_price - max_profits[transaction - 1])
                else:
                    # for transaction 0, just consider current price for comparison
                    # as we don't have max_profit calculated yet for the transaction being the first one.
                    min_costs[transaction] = min(min_costs[transaction], current_price)

                max_profits[transaction] = max(max_profits[transaction], current_price - min_costs[transaction])

        return max_profits[-1]



# Driver code
solution = Solution()
array, k = get_input()
print(f"Input: Array of prices: {array}")
print(f"Input: Maximum number of allowed transactions: {k}")
print(f"Output:  Maximum profit that can be achieved by buying and selling the stock with at the most two transactions: {solution.maxProfit_IV(k, array)}")
