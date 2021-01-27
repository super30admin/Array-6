class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        lowSoFar = 1000000
        for i in range(len(prices)):
            
            lowSoFar = min(lowSoFar, prices[i])
            profit = max(profit, prices[i]-lowSoFar)
            
        return profit
            
        
Time: O(N)
Space: O(1)
