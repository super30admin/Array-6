# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

# we are maintaing 4 variables
# buy1 - to keep track of the min value that we have encountered till now
# sell1 - keeps track of the max profit that we can get for any one transaction till the current index
# buy2 - keeps track of the profit till now, even after 1st transaction, that is check which is min, the earlier buy2 or current price - profit uptil now
# sell2 - keeps track of the max profit with 2 transactions till the current index

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # declare variables with default values
        buy1 = prices[0]
        sell1 = 0
        buy2 = prices[0]
        sell2 = 0
        
        n = len(prices)
        
        # traverse over the prices array
        for i in range(1,n):
            # update the buying prices with the min till now
            buy1 = min(buy1, prices[i])
            
            # find the profit and store it in sell1
            sell1 = max(sell1, prices[i] - buy1)
            
            # check if we can fetch more profit after subtracting the prev profit (sell1) to the current price
            buy2 = min(buy2, prices[i] - sell1)
            
            # find the max profit with the prev profit included in buying cost and then selling to fetch the max profit
            sell2 = max(sell2, prices[i] - buy2)
        
        # return the max profit which is stored in sell2
        return sell2
