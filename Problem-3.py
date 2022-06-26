class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices or len(prices)<2:
            return 0
        buy=[float('inf') for i in range(k+1)]
        profit=[0 for i in range(k+1)]
        
        for price in prices:
            for i in range(1,k+1):
                buy[i]=min(buy[i],price-profit[i-1])
                profit[i]=max(profit[i],price-buy[i])
                
        return profit[k]
        