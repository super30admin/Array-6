#Time complexity=O(n)
#Space Complexity= O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        buy=float("inf")
        profit=0
        
        for price in prices:
            buy=min(buy,price)
            profit=max(profit,price-buy)
        return profit
