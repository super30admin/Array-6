"""
## Problem 309: Best Time to Buy and Sell Stock with Cooldown

## Author: Neha Doiphode
## Date:   11-24-2022

## Description:
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve.
    You may complete as many transactions as you like
    (i.e., buy one and sell one share of the stock multiple times)
    with the following restrictions:
        After you sell your stock, you cannot buy stock on the next day
        (i.e., cooldown one day).

    Note: You may not engage in multiple transactions simultaneously
    (i.e., you must sell the stock before you buy again).

## Examples:
    Example 1:
        Input: prices = [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]

    Example 2:
        Input: prices = [1]
        Output: 0

## Constraints:
    1 <= prices.length <= 5000
    0 <= prices[i] <= 1000

## Notes:
    As a reminder, the nature of dynamic programming is to break the original problem into several subproblems,
    and then reuse the results of subproblems for the original problem.

## Time complexity: O(n), where n is the length of prices array.

## Space complexity: O(1), as we don't use any auxiliary array.

"""

from typing import List, Optional

def get_input():
    print("Enter array of integers(with spaces): ", end = "")
    array = input()
    array = [int(inp) for inp in array.split()]

    return array

class Solution:
    def maxProfit_with_cooldown_period(self, prices: List[int]) -> int:
        """
        State machine:
                   _ _ _ _
                  |       |
                  |_ _  Held
                      /      \
                   BUY       SELL
                   /            \
            _ _ _Rest _ _ _ _ _ Sold
            |     |
            |_ _ _|

        Rules:
            sold[i] = held[i-1] + price[i]
            held[i] = max(held[i - 1], rest[i - 1] - price[i])
            rest[i] = max(rest[i - 1], sold[i - 1])

            sold[i]: the previous state of sold can only be held. Therefore, the
                     maximal profits of this state is the maximal profits of the
                     previous state plus the revenue by selling the stock at the
                     current price.

            held[i]: the previous state of held could also be held, i.e. one does no
                     transaction. Or its previous state could be reset, from which
                     state, one can acquire a stock at the current price point.

            rest[i]: the previous state of reset could either be reset or sold.
                     Both transitions do not involve any transaction with the stock.

            The maximal profits that we can gain from this game would be
            max⁡(max(sold[n], rest[n]), i.e. at the last price point, either we sell
            the stock or we simply do no transaction, to have the maximal profits. It
            makes no sense to acquire the stock at the last price point, which only
            leads to the reduction of profits.

            In particular, as a base case, the game should be kicked off from the
            state rest, since initially we don't hold any stock and we don't have any
            stock to sell neither. Therefore, we assign the initial values of
            sold[-1] and held[-1] to be Integer.MIN_VALUE, which are intended to
            render the paths that start from these two states impossible.
        """

        sold, held, rest = float("-inf"), float("-inf"), 0
        pre_sold = None
        for i in range(len(prices)):
            pre_sold = sold
            sold = held + prices[i]
            held = max(held, rest - prices[i])
            rest =  max(rest, pre_sold)

        return max(sold, rest)

# Driver code
solution = Solution()
array = get_input()
print(f"Input: Array of prices: {array}")
print(f"Output: Maximum profit that can be achieved by buying and selling the stock with cooldown period of 1 day: {solution.maxProfit_with_cooldown_period(array)}")
