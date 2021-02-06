"""
Time Complexity : O(n) 
Space Complexity : O(n)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, this problem is very similar to the house robber problem. At every point, we are maintaining the effective profit.
If the stock is already bought, we can either sell or not. If the stock has already been sold, we can either buy or not.
So, in buy array, we are maintaining effective profit and taking max of profit made till now(if dont buy at this point of time), or 
if we buy right now, then profit would be the total profit after selling 2 steps back minus the current price. This is maintained
in buy array. In sell array, we take max of last profit(if we dont sell right now) or difference between current price and profit
when last bought. At the end, the last sell value would be our max profit.
"""


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices) < 2:
            return 0
        n = len(prices)
        buy = [0]*n
        sell = [0]*n
        buy[0] = -prices[0]
        buy[1] = max(buy[0], 0-prices[1])
        sell[1] = max(sell[0], prices[1]+buy[0])
        for i in range(2, n):
            buy[i] = max(buy[i-1], sell[i-2]-prices[i])
            sell[i] = max(sell[i-1], prices[i]+buy[i-1])
        return sell[-1]
