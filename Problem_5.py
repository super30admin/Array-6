'''
122. Best Time to Buy and Sell Stock II
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

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

Solution:
1. Recursion (Brute Force)
On any day, we have two choices
If not owning a stock, then
    - buy stock or do nothing
    - profit = max(profit due to buy, profit due to no buy)

If owning a stock, then
    - sell stock or do nothing
    - profit = max(profit due to sell, profit due to no sell)

Time: O(2^N), Space: O(N) (recursive stack)

2. DP Tabulation
buy = [0]*N,  (buy[i] = max profit from buying on day i, i>0)
sell = [0]*N  (sell[i] = max profit from selling on day i, i>0)

Init: This is the tricky part of this DP problem. On day 0, we set buy to -prices[0] (since we spend the buy amount on day 0 to buy the stock) and we set sell to 0 since we cannot sell on the 1st day.

Note that on day 0, we do not set profit = max(profit from buy (-ve no.), profit from dont buy (0)) since if we do this the profit will always be 0. This will affect subsequent values of the dp array. Thus, on day 0, we set buy = profit from buying the stock (a -ve amount), and sell = 0

We track the best profit for each day based on whether we are holding a stock (buy[i]) or not (sell[i]).

When buying on day i, buy[i] = max(a, b)
a = profit from our previous sell transaction used to buy the stock = sell[i-1] - prices[i].
b = profit from not buying which is simply equal to carrying over the profit from the previous buy txn (buy[i-1]).

When selling, our sell[i] = max(c,d)
c = profit from our previous buy + sale proceeds of the stock sold at the current price (prices[i])
d = profit from not selling which is simply equal to carrying over the profit from the previous sell txn (sell[i-1])).
Time: O(N), Space: O(N)

3. Valley-Peak
We can time the market if we buy on every local minima and sell on every local maxima. Timing the market leads to max profit. Thus, the most optimal path in the recursion (brute force) solution is also the greedy path solution (timing the market).
https://youtu.be/K8iHi8AW1ls?t=337
Time: O(N), Space: O(1)
'''

def maxProfit2_recursion(prices) -> int:
    ''' Time: O(2^N), Space: O(N) '''
    def recurse(prices, index, buy, profit):
        if index == N:
            return profit

        if buy:
            # buy because we are NOT already holding a share
            case1 = recurse(prices, index+1, 0, profit - prices[index])
            # we set profit = profit - prices[index], since after the buying
            # the stock our account is down by the purchase price of the stock

            # dont buy (skip)
            case2 = recurse(prices, index+1, 1, profit)
        else: # can't buy because we are already holding a share
            # sell because we are already holding a share
            case1 = recurse(prices, index+1, 1,  profit + prices[index])
            # dont sell (skip)
            case2 = recurse(prices, index+1, 0, profit)

        m = max(case1, case2) # max of the two profits
        return m

    N = len(prices)
    if N <= 1:
        return 0
    profit = recurse(prices, 0, 1, 0)
    return profit

def maxProfit2_dp(prices) -> int:
    ''' Time: O(N), Space: O(N) '''
    N = len(prices)
    if N <= 1:
        return 0
    buy  = [0]*N
    sell = [0]*N

    buy[0] = -prices[0]
    buy[1] = max(buy[0], sell[0] - prices[1])
    sell[1] = max(sell[0], prices[1] + buy[0])

    for i in range(2,N):
        buy[i] = max(buy[i-1], sell[i-1] - prices[i])
        sell[i] = max(sell[i-1], prices[i] + buy[i-1])
    return sell[N-1]


def maxProfit2_peakvalley(prices) -> int:
    ''' Time: O(N), Space: O(1) '''
    N = len(prices)
    if N <= 1:
        return 0
    sum = 0
    for i in range(1, N): # O(N)
        delta = prices[i] - prices[i-1]
        if delta > 0: # profit trade
            sum += delta
    return sum # max profit

def run_maxProfit2():
    tests = [([7,1,5,3,6,4], 7),
             ([1,2,3,4,5], 4),
             ([7,6,4,3,1], 0),
    ]
    for test in tests:
        prices, ans = test[0], test[1]
        print(f"\nprices = {prices}")
        for method in ['recursion', 'dp', 'peak-valley']:
            if method == 'recursion':
                profit = maxProfit2_recursion(prices)
            elif method == 'dp':
                profit = maxProfit2_dp(prices)
            elif method == 'peak-valley':
                profit = maxProfit2_peakvalley(prices)
            print(f"Method {method}: profit = {profit}")
            success = (ans==profit)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_maxProfit2()