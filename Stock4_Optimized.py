# Time complexity : O(n*k)
# Space complexity : O(k)
# Leetcode : Solved and submitted

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
       # declare empty lists for buy and sell values of size k
        buy = [float('inf')]*(k+1)
        sell = [0]*(k+1)
        
        # if we are allowed more or equal to half the len of prices transcations, then add all the profits
        if k >= len(prices) // 2:
            max_profit = 0
            for i in range(len(prices)-1):
                if prices[i+1] > prices[i]:
                    max_profit += prices[i+1] - prices[i]
            return max_profit
        
        # traverse over the prices array
        for i in range(len(prices)):
            # traverse over the lenght of k
            for j in range(1, k+1):
                # find the buying prices which is the min of the current buy price and the diff of prev sell and current prices
                buy[j] = min(buy[j], prices[i] - sell[j-1])
                
                # find the profit by finding the max of current sell or diff of current price and prev buy
                sell[j] = max(sell[j], prices[i] - buy[j])
        
        # return the last value in sell which is the max profit earned
        return sell[k]
