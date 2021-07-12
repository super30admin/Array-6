class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        
        buy = float('inf')
        profit = 0
        
        for price in prices:
            buy = min(buy,price)
            profit = max(profit,price - buy )
            
        return profit
    
