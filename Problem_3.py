"""
Time Complexity : O(n) if k>n/2 and O(nk) if it is lesser 
Space Complexity : O(1)  if k>n/2 and O(k) if it is lesser 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

This problem is similar to buy and sell stock 3. There we had to make atmost 2 transactions, here we have k transactions.
So we make an array to store those buy and sell variables and do the same operation. Also, we could optimise this in case
our k is more than n/2. This means that we have to do as many transactions as we can to calculate profit from the whole
array. This makes it equavalent to buy and sell stock 2.
"""


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if k > n//2:
            profit = 0
            for i in range(1, n):
                if prices[i] > prices[i-1]:
                    profit += prices[i]-prices[i-1]
            return profit

        buy = [inf]*(k+1)
        sell = [0]*(k+1)

        for i in range(n):
            for j in range(1, k+1):
                buy[j] = min(buy[j], prices[i]-sell[j-1])
                sell[j] = max(sell[j], prices[i]-buy[j])
        return sell[-1]
