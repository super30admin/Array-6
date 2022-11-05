# Time complexity : O(n^n)
# Space complexity : O(1)
# Leetcode : Time Limit Exceeded

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # define default value of max_profit and find the length of the prices array
        max_profit = 0
        n = len(prices)
        
        # traverse over the prices array with index i for buying the stock
        for i in range(n):
            # traverse from i+1 th index to check for profit with respect to selling price
            for j in range(i+1,n):
                # if price of j is greater than price of index i, then we can make a profit, get the max until the end
                if prices[j] > prices[i]:
                    max_profit = max(max_profit, prices[j] - prices[i])

        # return the max profit
        return max_profit
