"""

## Problem 714: Best Time to Buy and Sell Stock with Transaction Fee

## Author: Neha Doiphode
## Date:   11-24-2022

## Description
    You are given an array prices where prices[i] is the price of a given stock on the ith day,
    and an integer fee representing a transaction fee.

    Find the maximum profit you can achieve.
    You may complete as many transactions as you like,
    but you need to pay the transaction fee for each transaction.

    Note: You may not engage in multiple transactions simultaneously
          (i.e., you must sell the stock before you buy again).

## Examples:
    Example 1:
        Input: prices = [1,3,2,8,4,9], fee = 2
        Output: 8
        Explanation: The maximum profit can be achieved by:
                        - Buying at prices[0] = 1
                        - Selling at prices[3] = 8
                        - Buying at prices[4] = 4
                        - Selling at prices[5] = 9
                        The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

    Example 2:
        Input: prices = [1,3,7,5,10,3], fee = 3
        Output: 6

## Constraints:
    1 <= prices.length <= 5 * 104
    1 <= prices[i] < 5 * 104
    0 <= fee < 5 * 104


# Time complexity: O(n), where n is the length of prices array.

## Space complexity: O(1), as we don't use any auxiliary array.


"""

from typing import List, Optional

def get_input():
    print("Enter array of integers(with spaces): ", end = "")
    array = input()
    array = [int(inp) for inp in array.split()]

    print("Enter the fee(integer) per transaction(Buy-Sell): ", end = "")
    fee = int(input())
    return array, fee

class Solution:
    def maxProfit_with_transaction_fee(self, prices: List[int], fee: int) -> int:

        if len(prices) < 2:
            return 0

        max_profit = 0
        cash_in_hand = prices[0]

        for current_price in prices:
            if current_price < cash_in_hand:
                cash_in_hand = current_price

            elif current_price > cash_in_hand + fee:
                max_profit += current_price - cash_in_hand - fee

                # 0 1 4
                # current_price = 4, fee = 2, max_profit = 4 - 0 - 2 = 2
                # Hence, to buy next stock, after adding max_profit,
                # our new actual cash in hand would be current price excluding
                # transaction fees that would be required for the next transaction
                cash_in_hand = current_price - fee

        return max_profit

# Driver code
solution = Solution()
array, fee = get_input()
print(f"Input: Array of prices: {array}")
print(f"Input: Transaction fee: {fee}")
print(f"Output: Maximum profit that can be achieved by buying and selling the stock with transaction fee {fee}: {solution.maxProfit_with_transaction_fee(array, fee)}")
