# for 2 transactions we will spend n time making total complexity n*n.
# Hence we consider both of these transactions as a single one and store the profit of first transaction into buy2 and make buy2 negative to get profit of both transactions in profit2
# TC - O(n)

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1 = prices[0]
        profit1 = 0
        buy2 = prices[0]
        profit2 = max(0, prices[0]-buy2)
        for i in range(1, len(prices)):
            buy1 = min(buy1, prices[i])
            profit1 = max(profit1, prices[i]-buy1)
            # making buy2 negative by storing the profit in this value
            buy2 = min(buy2, prices[i] - profit1)
            profit2 = max(profit2, prices[i]-buy2)
        return profit2
        