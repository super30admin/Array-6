class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        
        if not prices:
            return 0
        
        
        if k>=len(prices)//2:
            ans = 0
            for i in range(1,len(prices)):
                ans += max(0,prices[i]-prices[i-1])
            return ans
        
        
        cost = [float("inf") for i in range(k+1)]
        profit = [0 for i in range((k+1))]
 
        for price in prices:
            for i in range(1,(k+1)):
                cost[i] = min(cost[i], price-profit[i-1])
                profit[i] = max(profit[i], price-cost[i])
 
        
        return profit[-1]
    
Time: NK
Space: O(K)
