'''
309 Best Time To Buy and Sell Stock with Cooldown
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/


You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:
Input: prices = [1]
Output: 0

Constraints:
1 <= prices.length <= 5000
0 <= prices[i] <= 1000

Notes:
 - Structure of Recursion-1 is closer to the DP solutions than Recursion-2
 - Hence, recommend following Recursion-1 and DP-1 (3 state DP) or DP-2 (2 state DP)

Solution:
1. Recursion-1
On any day, we have two choices
If not owning a stock, then
    - buy stock or do nothing
    - profit = max(profit due to buy, profit due to no buy)

If owning a stock, then
    - sell stock or do nothing
    - profit = max(profit due to sell, profit due to no sell)


Thus, if we haven't bought yet (prevBuy == -1), we can either skip buying or buy today.

If we've bought already, we can either skip selling or sell the stock — and if we sell, we apply a cooldown by skipping to the next day (idx + 2).

We track profit across each choice and return the best possible one at the end.

https://youtu.be/Xr5bTeXTJC8?t=308  (Key idea: On any day - we have buy/sell choices. Within buy/sell, we have case1 (do) and case2 (don't), 5:08-14:00)
https://youtu.be/Xr5bTeXTJC8?t=844 (coding the recursive solution)

Time: O(2^N), Space: O(N), N = no. of elements in the prices list
(We get a TLE error because of 2^N complexity)

2. Recursion-2
This is similar to Recursion-1 except for the two arguments
prev_buy, profit in the recurse function

Here, we use buy as a flag to decide whether to buy(1) or sell(0)
Next, we compute the net profit after
 - a buy transaction by deducting the buy price from the previous profit
 - a sell transaction by adding the sell price to the previous profit

Profit computation in Recursion-2 is in line with the way profit in DP (next solution) is computed. Hence, this is slightly easier to follow.

3. DP Tabulation - 1
For each day, we define the 3 states as
hold[i] = profit by holding 1 stock on day i
sold[i] = profit by selling 1 stock on day i
rest[i] = profit by not holding any stock on day i

Now, we figure out the strate transitions from day i-1 that lead to the target state on day i

day  i-1                    ->    action on day i   profit on day i
not holding stock (rest[i-1]) -->     no action     rest[i]
sold stock  (sold[i-1])       -->     no action     sold[i-1]
Since we are not holding stock on day i, state on day i = rest[i]
rest[i] = max(rest[i-1], sold[i-1])

day  i-1                    ->    action on day i  profit on day i
holding stock (hold[i-1])      -->  no action      hold[i-1]
not holding stock (rest[i-1])  -->  buy stock     rest[i-1] - prices[i]
Since we are holding the stock on day i, state on day i = hold[i]
hold[i] = max(hold[i-1], rest[i-1] - prices[i])

day  i-1                    ->    action on day i  profit on day i
holding stock (hold[i-1])      -->  sold          hold[i-1] + prices[i]
Since we sold the stock on day i, state on day i = sold[i]
sold[i] = hold[i-1] + prices[i]

We init for day 0 using
hold[0], rest[0], sold[0] = -prices[0], 0, 0

If we buy on day 0 by spending prices[0], at the end of the day
our state is hold[0] with a profit of -prices[0]

We then calculate the 3 states for the remaining days as follows:
for i in range(1,N):
    rest[i] = max(rest[i-1], sold[i-1])
    hold[i] = max(hold[i-1], rest[i-1] - prices[i])
    sold[i] = hold[i-1] + prices[i]

Finally, we return max(rest[N-1], sold[N-1]). There is no point in
including hold[N-1] in max() because hold[N-1] means that  we are holding a stock on the last day for which we would have spent prices[N-1]. Hence,
hold[N-1] is the lower valued state (compared to rest[N-1] and sold[N-1]).
https://youtu.be/4wNXkhAky3s?t=894 (14:54 - 28:00)
Time: O(N), Space: O(N)

4. DP Tabulation - 2
In DP - 1, we used 3 states. Here, we use 2 states.
For each day, we define the 2 states
hold = [0]*N,  (hold[i] = max profit from holding a stock on day i)
sold = [0]*N   (sold[i] = max profit from selling on day i)

Init: This is the tricky part of this DP problem. We manually int for day 0 and day 1.

On day 0, we set buy to -prices[0] (since we start with $0 profit and we spend the buy amount on day 0 to buy the stock) and we set sell to 0 since we cannot sell on the 1st day.
hold[0] = -prices[0]
sold[0] = 0

On day 1, if we held a stock on day 1, then there are 2 possible cases
a) we were holding it yesterday and continue to hold today (no action today)
b) we were not holding a stock yesterday, but bought it today
hold[1] = max(hold[0], -prices[1])

If we sold a stock on day 1, then there are 2 possible cases
a) we sold it yesterday (at $0), and didn't do anything today (no action today)
b) we bought it yesterday and sold it today
sold[1] = max(sold[0], hold[0] + prices[1])

For day 2 and higher:
If we are holding a stock today, then there are 2 possible cases
a) we were holding it yesterday and continue to hold today (no action today)
b) we sold a stock day before yesterday, and buying it today
Thus, hold[i] = max(hold[i-1], sold[i-2] - prices[i])

If we don't have any stock today, then there are 2 possible cases
a) we sold it yesterday and didn't do anything today (no action today)
b) we were holding a stock day yesterday, and sold it today
Thus, sold[i] = max(sold[i-1], hold[i-1] + prices[i])

https://youtu.be/Xr5bTeXTJC8?t=2077 (Dry run 1)
https://youtu.be/Xr5bTeXTJC8 (On day 0, why do we set buy price = -prices[0] and not max(0, -prices[0]) )
https://youtu.be/Xr5bTeXTJC8?t=2723 (Dry run 2)

Time: O(N), Space: O(N)


What is the similarity between DP-1 (3 states) and DP-2 (2 states)?
Recall, in DP-1, we have,
for i in range(1,N):
    rest[i] = max(rest[i-1], sold[i-1])
    hold[i] = max(hold[i-1], rest[i-1] - prices[i])
    sold[i] = hold[i-1] + prices[i]
return max(rest[N-1], sold[N-1])

And, in DP-2, we have,
for i in range(2,N):
    hold[i] = max(hold[i-1], sold[i-2] - prices[i])
    sold[i] = max(sold[i-1], hold[i-1] + prices[i])
return sold[N-1]


We first compare hold[] computations for DP-2 vs DP-1 :
DP-2
hold[i] = max(hold[i-1], sold[i-2] - prices[i])

DP-1
rest[i] = max(rest[i-1], sold[i-1])
hold[i] = max(hold[i-1], rest[i-1] - prices[i])
        = max(hold[i-1], max(rest[i-2], sold[i-2]) - prices[i])
Thus, in both cases, hold[i] is a func of hold[i-1], sold[i-2], prices[i]

Next, we compare sold[] computations for DP-2 vs DP-1:
DP-2
sold[i] = max(sold[i-1], hold[i-1] + prices[i])

DP-1:
rest[i] = max(rest[i-1], sold[i-1])
sold[i] = hold[i-1] + prices[i]
Then, max(rest[i], sold[i])
= max( max(rest[i-1], sold[i-1]), hold[i-1] + prices[i])
Thus, in both cases, sold[i] is a func of sold[i-1], hold[i-1], prices[i]

'''
from typing import List
def maxProfitcoolDown_recursion1(prices: List[int]) -> int:
    ''' Time: O(2^N), Space: O(N) '''
    def recurse(prices, index, prev_buy, profit):
        # prev_buy = purchase price of the stock it was last bought at
        if index >= N:
            return profit

        if prev_buy == -1: # haven't bought yet, ready to buy
            # buy
            case_1 = recurse(prices, index+1, prices[index], profit)
             # do not buy
            case_2 = recurse(prices, index+1, prev_buy, profit)
        else: # already have stock, ready to sell now
            # sell (set prev_buy to -1 to flag that we can go to the buy case
            # in the next recursive call)
            case_1 = recurse(prices, index+2, -1, profit + prices[index] - prev_buy)
            # do not sell
            case_2 = recurse(prices, index+1, prev_buy, profit)
        return max(case_1, case_2)

    if not prices or len(prices) < 2:
        return 0
    N = len(prices)
    profit = recurse(prices, 0, -1, 0)
    return profit

def maxProfitcoolDown_recursion2(prices: List[int]) -> int:
    ''' Time: O(2^N), Space: O(N) '''
    def recurse(prices, index, buy, profit):
        # buy = boolean to indicate whether we can buy or not (sell)
        if index >= N:
            return profit

        if buy: # haven't bought yet, ready to buy now
            # buy because we are NOT already holding a share
            case1 = recurse(prices, index+1, 0, profit - prices[index])
            # Notes:
            # 1. We might as well use index instead of index+1 to indicate that
            # we sell at the same price in the next transaction; however, this
            # will result in 0 profit (buying and selling at the same price)
            # which is a meaningless step. Hence, we could use index+1
            # 2. We set profit = profit - prices[index], since after the buying
            # the stock our account is down by the purchase price of the stock

            # don't buy (after don't buy, we are still not holding a share)
            case2 = recurse(prices, index+1, 1, profit)
        else: # already have stock, ready to sell now
            # sell because we are already holding a share
            case1 = recurse(prices, index+2, 1, profit + prices[index])
            # don't sell (after don't sell, we are holding a share)
            case2 = recurse(prices, index+1, 0, profit)
        m = max(case1, case2)
        return m

    if not prices or len(prices) < 2:
        return 0
    N = len(prices)
    profit = recurse(prices, 0, 1, 0)
    return profit

def maxProfitcoolDown_dp1(prices: List[int]) -> int:
    ''' 3 state DP
        Time: O(N), Space: O(N)
    '''
    if not prices or len(prices) < 2:
        return 0
    N = len(prices)
    hold = [0]*N
    rest = [0]*N
    sold = [0]*N

    hold[0], rest[0], sold[0] = -prices[0], 0, 0
    for i in range(1,N):
        rest[i] = max(rest[i-1], sold[i-1])
        hold[i] = max(hold[i-1], rest[i-1] - prices[i])
        sold[i] = hold[i-1] + prices[i]
    return max(rest[N-1], sold[N-1])

# def maxProfitcoolDown_dp2(prices: List[int]) -> int:
#     ''' 2 state DP
#         Time: O(N), Space: O(N)
#     '''
#     if not prices or len(prices) < 2:
#         return 0
#     N = len(prices)
#     buy = [0]*N
#     sell = [0]*N

#     buy[0] = -prices[0]
#     buy[1] = max(buy[0], sell[0] - prices[1])
#     sell[1] = max(sell[0], buy[0] + prices[1])

#     for i in range(2,N):
#         buy[i] = max(buy[i-1], sell[i-2] - prices[i])
#         sell[i] = max(sell[i-1], prices[i] + buy[i-1])
#     return sell[N-1]

def maxProfitcoolDown_dp2(prices: List[int]) -> int:
    ''' 2 state DP (remove 'rest' state from 3 state DP)
        Time: O(N), Space: O(N)
    '''
    if not prices or len(prices) < 2:
        return 0
    N = len(prices)
    hold = [0]*N
    sold = [0]*N

    # init for day 0 and day 1
    hold[0] = -prices[0]
    hold[1] = max(hold[0], -prices[1])
    sold[1] = max(sold[0], hold[0] + prices[1])

    # for day 2 and beyond
    for i in range(2,N):
        # If we are holding a stock today, then there are 2 possible cases
        # a) we were holding it yesterday and continue to hold today (no action)
        # b) we sold a stock day before yesterday, and buying it today
        hold[i] = max(hold[i-1], sold[i-2] - prices[i])

        # If we don't have any stock today, then there are 2 possible cases
        # a) we sold it yesterday and didn't do anything today (no action)
        # b) we were holding a stock day yesterday, and sold it today
        sold[i] = max(sold[i-1], hold[i-1] + prices[i])
    return sold[N-1]

def run_maxProfitcoolDown():
    tests = [([1,2,3,0,3,1,6,9], 10),
             ([1,2,3,0,2], 3),
    ]
    for test in tests:
        prices, ans = test[0], test[1]
        print(f"\nprices = {prices}")
        for method in ['recursion1', 'recursion2', 'dp1', 'dp2']:
            if method == 'recursion1':
                profit = maxProfitcoolDown_recursion1(prices)
            elif method == 'recursion2':
                profit = maxProfitcoolDown_recursion2(prices)
            elif method == 'dp1':
                profit = maxProfitcoolDown_dp1(prices)
            elif method == 'dp2':
                profit = maxProfitcoolDown_dp2(prices)
            print(f"Method {method}: profit = {profit}")
            success = (ans==profit)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_maxProfitcoolDown()