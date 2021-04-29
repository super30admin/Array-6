#Time Complexity:O(nk)
#Space Complexity:O(k)

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        buy=[float("Inf") for i in range(k+1)]
        profit=[0 for i in range(k+1)]
        for price in prices:
            for j in range(1,k+1):
                buy[j]=min(buy[j],price-profit[j-1])
                profit[j]=max(profit[j],price-buy[j])
                
        return profit[k]
