'''
123 Best Time to Buy and Sell Stock III
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^5

Solution:
1. Brute Force
Complete the first pair of transactions by buying first and selling on a future day. Then after the sale, repeat the buy-sell acitivity to account for the second transaction.

Consider prices = [3,3,5,0,0,3,1,4]
Let buy1 = prices[0]
buy1 = 3, sell1 = 3, buy2 = 2, sell2 = 0,0,3,1,4
buy1 = 3, sell1 = 5, buy2 = 0, sell2 = 0,3,1,4
buy1 = 3, sell1 = 0, buy2 = 0, sell2 = 3,1,4
.
.
.
buy1 = 3, sell1 = 3, buy2 = 1, sell2 = 4

Next, move to the next buy1 = prices[1]
buy1 = 3, sell1 = 5, buy2 = 0, sell2 = 0,3,1,4
buy1 = 3, sell1 = 0, buy2 = 0, sell2 = 3,1,4
buy1 = 3, sell1 = 0, buy2 = 3, sell2 = 1,4
buy1 = 3, sell1 = 3, buy2 = 1, sell2 = 4

Next, move to the next buy1 = prices[2]
buy1 = 5, sell1 = 0, buy2 = 0, sell2 = 3,1,4
.
.
.

https://youtu.be/e1M19caPt7c?t=2743

Time: O(N^2 * N^2) = O(N^4), Space: O(1)

2. State Machine
We extend the running min and running max approach of the previous problem "121 Best Time to Buy and Sell Stock". There we maintained 1 pair of variables (buy and sell) to complete 1 transaction (round trip activity). To accound for the 2nd transactions, we instroduce another pair of state variables.

We track the lowest price to make the first buy and calculate the best first profit. We include the profit from the first transaction by adjusting the cost of the second buy (i.e., reduce price by first profit). The profit from the second transaction represents the total profit from both transactions combined.

https://youtu.be/e1M19caPt7c?t=3257

Time: O(N), Space: O(1)
'''
from typing import List

def maxProfit3_recursion(prices: List[int]) -> int:
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
    k = 2
    profit = recurse(prices, 0, 1, 0, k)
    return profit

def maxProfit3_dp(prices: List[int]) -> int:
    ''' Time: O(N), Space: O(1) '''
    if not prices:
        return 0
    N = len(prices)
    b1, s1 = float('inf'), 0
    b2, s2 = float('inf'), 0
    for i in range(N):
        b1 = min(b1, prices[i])
        s1 = max(s1, prices[i]-b1)
        b2 = min(b2, prices[i]-s1)
        s2 = max(s2, prices[i]-b2)
    return s2

def run_maxProfit3():
    tests = [([3,3,5,0,0,3,1,4], 6),
             ([1,2,3,4,5], 4),
             ([7,6,4,3,1], 0)
    ]
    for test in tests:
        prices, ans = test[0], test[1]
        print(f"\nprices = {prices}")
        for method in ['recursion', 'dp']:
            if method == 'recursion':
                profit = maxProfit3_recursion(prices)
            elif method == 'dp':
                profit = maxProfit3_dp(prices)
            print(f"Method {method}: max profit = {profit}")
            success = (ans==profit)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_maxProfit3()