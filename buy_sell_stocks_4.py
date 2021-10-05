#Time Complexity: O(NK) #N is #of elements in array , k is #transactions allowed

#Space Complexity: O(k) 
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        profit = [0]*(k+1)
        buy = [float('inf')]*(k+1)
        
        for item in prices:
            for j in range(1,k+1):
                buy[j] = min(buy[j],item-profit[j-1])
                
                profit[j] = max(profit[j],item-buy[j])
        return profit[k]
        
        