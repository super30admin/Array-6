class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices :
            return 0
        
        buy1, profit1, buy2, profit2 = float('inf'),0,float('inf'),0
        
        for price in prices:
            
            buy1 = min(buy1, price)
            profit1 = max(profit1, price - buy1)
            
            buy2 = min(buy2, price - profit1)
            profit2 = max (profit2, price - buy2)
            
        return profit2
        
        
