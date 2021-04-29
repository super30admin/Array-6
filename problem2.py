#Solution 1

#Time Complexity: O(n)
#Space Complexity:O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        buy1=float("Inf")
        buy2=float("Inf")
        profit1=0
        profit2=0
        
        for price in prices:
            buy1=min(buy1,price)
            profit1=max(profit1,price-buy1)
            
            buy2=min(buy2,price-profit1)
            profit2=max(profit2,price-buy2)
            
        return profit2
     
#Solution 2:

#Time Complexity: O(n)
#Space Complexity:O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0

        buy=[float("inf") for i in range(3)]
        profit=[0 for i in range(3)]
        
        for price in prices:
            for j in range(1,3):
                buy[j]=min(buy[j],price-profit[j-1])
                profit[j]=max(profit[j],price-buy[j])
                
        return profit[2]
