"""
## Problem 121: Best time to buy and sell stocks

## Author: Neha Doiphode
## Date:   11-21-2022

## Description:
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
    in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

## Examples:
    Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                     Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.

## Constraints:
    1 <= prices.length <= 105
    0 <= prices[i] <= 104

## Time complexity: O(n), where n is the length of array of prices.

## Space complexity: O(1), as no auxiliary space is used.

"""

from typing import List, Optional


def get_input():
    print("Enter array of integers(with spaces): ", end = "")
    array = input()
    array = [int(inp) for inp in array.split()]
    return array


class Solution:
    def maxProfit_reverse(self, prices: List[int]) -> int:
        max_profit = 0
        max_index = -1

        for index in range(len(prices) - 2, -1, -1):
            if prices[index] < prices[max_index]:
                max_profit = max(max_profit, prices[max_index] - prices[index])
            else:
                max_index = index

        return max_profit

    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        lowest = prices[0]

        for index in range(1, len(prices)):
            if prices[index] < lowest:
                lowest = prices[index]

            max_profit = max(max_profit, prices[index] - lowest)

        return max_profit

# Driver code
solution = Solution()
array = get_input()
print(f"Input: Array of prices: {array}")
print(f"Output: Approach 1: Trace array in reverse order: Maximum profit that can be achieved by buying and selling the stock: {solution.maxProfit_reverse(array)}")
print(f"Output: Approach 2: Trace array: Maximum profit that can be achieved by buying and selling the stock: {solution.maxProfit(array)}")
