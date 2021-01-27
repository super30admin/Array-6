class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        firstCost = float("inf")
        secondCost = float("inf")
        
        firstProfit = 0
        secondProfit = 0
        
        
        for cost in prices:
            
            firstCost = min(firstCost, cost)
            
            firstProfit = max(firstProfit, cost-firstCost)
            
            secondCost = min(secondCost, cost-firstProfit)
            
            secondProfit = max(secondProfit, cost-secondCost)
            
        return secondProfit
Time: O(N)
Space: O(1)
