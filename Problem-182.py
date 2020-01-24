'''
Leet code - 121. Best Time to Buy and Sell Stock

'''
# Brute Force - Time limit exceeded

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxprofit=0
        for i in range(len(prices)-1):
            for j in range(i+1,len(prices)):
                profit=prices[j]-prices[i]
                if profit >maxprofit:
                    maxprofit=profit
                
        return maxprofit
    
    
    
# one pass

class Solution(object):
    def maxProfit(self, prices):
        max = 0
        min = float('inf')
        for price in prices:
            if price < min:
                min = price
            elif price - min > max:
                max = price - min
        return max