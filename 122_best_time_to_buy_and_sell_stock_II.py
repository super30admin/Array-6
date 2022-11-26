"""
## Problem 122: Best time to buy and sell stocks II

## Author: Neha Doiphode
## Date:   11-21-2022

## Description:
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.
    Find and return the total maximum profit you can achieve.

## Examples:
    Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                     Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
                     Total profit is 4 + 3 = 7.

    Example 2:
        Input: prices = [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                     Total profit is 4.

    Example 3:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

## Constraints:
    1 <= prices.length <= 3 * 104
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
    def maxProfit_II(self, prices: List[int]) -> int:
        lowest = prices[0]
        total_profit = 0

        for index in range(1, len(prices)):
            if prices[index] > lowest:
                total_profit += prices[index] - lowest

            lowest = prices[index]

        return total_profit

# Driver code
solution = Solution()
array = get_input()
print(f"Input: Array of prices: {array}")
print(f"Output: Total maximum profit that can be achieved by buying and selling the stock: {solution.maxProfit_II(array)}")
