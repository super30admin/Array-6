'''
188 Best Time To Buy And Sell Stock IV
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

Constraints:
1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000

Solution:
1. Recursion
Time: O(2^N), Space: O(N)

1. State Machine using DP
This is a generalization of the previous problem "Best Time to Buy and Sell Stock III". The previous problem involved at most 2 transactions and we maintained 2 states for each buy and sell activity. In this problem, we have at most k transactions. Correspondingly, we maintain k states for each buy and sell activity. Thus, we maintain the lowest effective buy price for jth buy using buy[j] and max profit for jth sell using sell[j]. The profit for transaction k is stored in sell[k] at the end.
https://youtu.be/sPOst2hE4_M?t=718
Time: O(NK), Space: O(K), N = no. of prices, K = no. of transactions
'''
from typing import List

def maxProfit4_recursion(k: int, prices: List[int]) -> int:
    ''' Time: O(2^N), Space: O(N) '''
    def recurse(prices, index, buy, profit, k):
        if index == N or k == 0:
            return profit

        if buy:
            # buy because we are NOT already holding a share
            case1 = recurse(prices, index+1, 0, profit - prices[index], k)
            # we set profit = profit - prices[index], since after the buying
            # the stock our account is down by the purchase price of the stock

            # dont buy (skip)
            case2 = recurse(prices, index+1, 1, profit, k)
        else: # can't buy because we are already holding a share
            # sell because we are already holding a share
            case1 = recurse(prices, index+1, 1,  profit + prices[index], k-1)
            # dont sell (skip)
            case2 = recurse(prices, index+1, 0, profit, k)

        m = max(case1, case2) # max of the two profits
        return m

    N = len(prices)
    if N <= 1:
        return 0
    profit = recurse(prices, 0, 1, 0, k)
    return profit

def maxProfit4_dp(k: int, prices: List[int]) -> int:
    if not prices:
        return 0
    N = len(prices)
    b = [float('inf')]*k
    s = [0]*k

    for day in range(N):
        for j in range(k):
            if j == 0:
                b[j] = min(b[j], prices[day])
            else:
                b[j] = min(b[j], prices[day] - s[j-1])
            s[j] = max(s[j], prices[day] - b[j])
    return s[k-1]


def run_maxProfit4():
    tests = [([2,4,1], 2, 2),
             ([3,2,6,5,0,3], 2, 7),
    ]
    for test in tests:
        prices, k, ans = test[0], test[1], test[2]
        print(f"\nprices = {prices}")
        print(f"k = {k}")
        for method in ['recursion', 'dp']:
            if method == 'recursion':
                profit = maxProfit4_recursion(k, prices)
            elif method == 'dp':
                profit = maxProfit4_dp(k, prices)
            print(f"Method {method}: profit = {profit}")
            success = (ans==profit)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_maxProfit4()
