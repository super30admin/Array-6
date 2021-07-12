class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices:
            return 0
        
        sell = [0] * (k +1)
        buy = [float('inf')]*  (k +1)
        
        
        for i in range(len(prices)):
            
            for j in range(1,k+1):

                buy[j] =  min(buy[j], prices[i] - sell[j-1] )
                sell[j] = max(sell[j], prices[i] - buy[j])
                
        return sell[-1]
                
        
