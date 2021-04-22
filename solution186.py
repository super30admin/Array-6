#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices)==1:
            return 0
        buy1=inf
        sell1=-inf
        buy2=inf
        sell2=-inf
        for price in prices:
            buy1=min(buy1,price)                                #find minimum between buy1 and current price
            sell1=max(sell1,price-buy1)                         #find maximum between sell1 and difference between current price and buy1
            buy2=min(buy2,price-sell1)                          #find minimum between buy2 and difference between current price and sell1
            sell2=max(sell2,price-buy2)                         #find maximum between sell2 and difference between current price and buy2
        return sell2