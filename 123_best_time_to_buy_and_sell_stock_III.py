"""
## Problem 123: Best Time to Buy and Sell Stock III

## Author: Neha Doiphode
## Date:   11-24-2022

## Description:
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve. You may complete at most two transactions.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

## Examples:
    Example 1:
        Input: prices = [3,3,5,0,0,3,1,4]
        Output: 6
        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
                     Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

    Example 2:
        Input: prices = [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                     Note that you cannot buy on day 1, buy on day 2 and sell them later,
                     as you are engaging multiple transactions at the same time.
                     You must sell before buying again.

    Example 3:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.

## Constraints:
    1 <= prices.length <= 105
    0 <= prices[i] <= 105

## Time complexity: O(n), where n is the number of prices present in the input array prices.

## Space complexity: O(1), no auxiliary space is used.

"""

from typing import List, Optional

def get_input():
    print("Enter array of integers(with spaces): ", end = "")
    array = input()
    array = [int(inp) for inp in array.split()]
    return array

class Solution:
    def maxProfit_III(self, prices: List[int]) -> int:
        # 1. We need to sell the stock before we buy next stock
        # 2. You can at the most do 2 transactions.
        min_cost1 = float("inf")
        min_cost2 = float("inf")
        max_profit1 = 0
        max_profit2 = 0

        for current_price in prices:
            min_cost1 = min(min_cost1, current_price)
            max_profit1 = max(max_profit1, current_price - min_cost1)

            # Whatever profit we got get transaction1, we can invest that into the second transaction
            min_cost2 = min(min_cost2, current_price - max_profit1)
            max_profit2 = max(max_profit2, current_price - min_cost2)

        return max_profit2

# Driver code
solution = Solution()
array = get_input()
print(f"Input: Array of prices: {array}")
print(f"Output:  Maximum profit that can be achieved by buying and selling the stock with at the most two transactions: {solution.maxProfit_III(array)}")
