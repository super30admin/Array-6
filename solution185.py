#Time Complexity:O(n)
#Space Complexity:O(1)
#Approach:Parse through the array finding the minimum element and the maximum between the current price and current minimum.
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices)==1:
            return 0
        profit=-inf
        minPrice=inf
        for price in prices:
            minPrice=min(minPrice,price)
            profit=max(profit,price-minPrice)
        return profit