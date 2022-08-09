'''
Solution:
1.  Only 1 transaction is allowed, and so keep updating the minimum buying price and potential profit at each instant
    with the available minimum buying price at that instant.
Time Complexity:    O(N)
Space Complexity:   O(1)
Run on Leet Code: Yes.
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        minBuy = float('inf')
        maxProfit = 0
        
        for i in range(0,len(prices)):
            # update minBuy if needed
            minBuy = min(minBuy,prices[i])
            
            # calculate possible profit
            profit = prices[i]-minBuy
            
            # update returnProfit with max possible value
            maxProfit = max(maxProfit,profit)
            
        return maxProfit