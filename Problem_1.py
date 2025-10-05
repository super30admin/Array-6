'''
121 Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4

Solution:
1. Brute Force
For each buy, sell at a future price. Thus, for every buy, we compute the max value that is to the right of buy and also greater than or equal to buy.

profit = 0
for buy in range(N):
    buy = prices[i]
    for  sell in range(i+1, N):
        sell = prices[j]
        profit = max(profit, sell - buy)


Alternatively, for each sell on the right part of the prices array, we buy at a past price. Thus, for every sell, we compute the min value among all the elements to the the left of sell and also lesser than or equal to sell.

https://youtu.be/e1M19caPt7c?t=1617

Time: O(N^2), Space: O(1)


https://youtu.be/e1M19caPt7c?t=1954
Time: O(N^2), Space: O(1)

2. State Machine
The problem with the Brute force approach is that when we compute the min of the values on the left of the sell price, we are repeating most of the min computations except 1.

eg. prices = [7,1,5,3,6,4]
If we sell at 4, buy = min{7,1,5,3,6} = 1. profit = sell - buy = 3
If we sell at 6, buy = min{7,1,5,3} = 1, profit = 5
Thus, in the second step above, we have repeated computing min{7,1,5,3,6} when it was already computed from the first step.

We could have avoided this step by doing the following:
If we sell at 4, buy = min {min{7,1,5,3} ,6} = 1
                     = min {m,6} = min (1,6} = 1, profit = sell - buy = 3
If we sell at 6, buy = m, profit = 6-1 = 5
Hence, there was no need to compute 'm' again in the second step.

Thus, the algorithm is: we keep track of the minimum price we've seen so far while iterating. After buying at the minimum price, at each day (day i), we calculate the current profit if we sold it on that day. Thus, the maximum profit
= max(sell on day i, don't sell on day i)
= max(sell on day i, accumulated profit until day i - 1)
We keep updating the maximum profit as go through the day i, ... N-1.

https://youtu.be/e1M19caPt7c?t=1954

Time: O(N), Space: O(1)
'''
from typing import List

def maxProfit1_recursion(prices: List[int]) -> int:
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
    k = 1
    profit = recurse(prices, 0, 1, 0, k)
    return profit

def maxProfit1_dp(prices: List[int]) -> int:
    ''' Time: O(N), Space: O(1) '''
    N = len(prices)
    if N == 1:
        return 0 # buy and sell the same day

    m = float('inf')
    M = 0
    for i in range(N):
        m = min(m, prices[i])
        M = max(M, prices[i] - m)

    return M


def run_maxProfit1():
    tests = [([7,1,5,3,6,4], 5),
             ([7,6,4,3,1], 0),
             ([1,2,3,4,5], 4),
             ([5,4,3,2,1], 0),
             ([5], 0),
             ]
    for test in tests:
        prices, ans = test[0], test[1]
        print(f"\nprices = {prices}")
        for method in ['recursion', 'dp']:
            if method == 'recursion':
                profit = maxProfit1_recursion(prices)
            elif method == 'dp':
                profit = maxProfit1_dp(prices)
            print(f"Method {method}: max profit = {profit}")
            success = (ans==profit)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_maxProfit1()
