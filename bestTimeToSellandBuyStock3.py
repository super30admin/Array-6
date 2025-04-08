class Solution:
    # TC : O(n)
    # SC : O(1)
    def maxProfit(self, prices: List[int]) -> int:
        if prices is None:
            return 0
        transaction1,transaction2 = float('inf'),float('inf')
        profit1,profit2 = 0,0
        for price in prices:
            transaction1 = min(transaction1,price)
            profit1 = max(profit1,price-transaction1)

            transaction2 = min(transaction2,price-profit1)
            profit2 = max(profit2,price-transaction2)
        return profit2
        