#Time Complexity:O(n)
#Space Complexity:O(n)
#use k+1 sized buy and sell arrays to hold the uy and sell values for each price in the prices input array.
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if len(prices)==1:
            return 0
        buy=[inf]*(k+1)
        sell=[0]*(k+1)
        for price in prices:
            for j in range(1,k+1):
                buy[j]=min(buy[j],price-sell[j-1])
                sell[j]=max(sell[j],price-buy[j])
        return sell[k]