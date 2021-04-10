class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        #O(N ^ 2) Time and O(1) space
        # TLE
        
        if not prices or len(prices) == 0:
            return 0
        
        max_profit = 0
        for i in range(len(prices)):
            for j in range(i+1, len(prices)):
                
                profit = prices[j] - prices[i]
                max_profit = max(max_profit, profit)
                
        return max_profit
    
    
  

# O(N) Time O(1) Space
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if not prices or len(prices) == 0:
            return 0
        
        min_price = prices[0] # min price we should have bought the stock to gain max profit
        max_profit = 0
        
        for i in range(1, len(prices)):
            if prices[i] < min_price:
                min_price = prices[i]
                
            elif prices[i] - min_price > max_profit:
                max_profit = prices[i] - min_price
                
        return max_profit
        
         
        