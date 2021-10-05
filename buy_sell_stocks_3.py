#Time Complexity: O(N) #N is #of elements in array

#Space Complexity: O(1) 
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        profit =0
        buy = float('inf')
        buy1 = float('inf')
        profit2 = 0
        for item in prices:
            buy = min(buy,item) #till that date what is minimum buying price
            profit = max(profit,item-buy) # profit if we sell on that date compared to previous profit
            buy1 = min(buy1,item-profit)
            profit2 = max(profit2,item-buy1)
        return profit2
        