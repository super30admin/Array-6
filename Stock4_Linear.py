# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # if the list is empty or len is less than 2, then return 0
        if not prices or len(prices) < 2:
            return 0
        
        # build the buy and sell list accorind to the size of n
        n = len(prices)
        buy = []
        sell = []
        
        # fill in the first 2 values for buy and sell arrays
        buy.append(-prices[0])
        sell.append(0)
        
        # for buy, the second paramter is the effective profit
        buy.append(max(buy[0],-prices[1]))
        sell.append(max(sell[0],buy[0] + prices[1]))
        
        # traverse through the prices list starting from 2nd index
        for i in range(2,n):
            # keep on appending the buy and sell based on the max profit we can make
            buy.append(max(buy[i-1], sell[i-2] - prices[i]))
            sell.append(max(sell[i-1], buy[i-1] + prices[i]))
        
        # return the last sell value in the list
        return sell[n-1]
