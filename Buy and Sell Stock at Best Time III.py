#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        buy1 = prices[0]
        sell1 = 0
        buy2 = prices[0]
        sell2 = 0
        for i in range(1,n):
            buy1 = min(buy1,prices[i])
            sell1 = max(sell1,prices[i]-buy1)
            buy2 = min(buy2,prices[i]-sell1)
            sell2 = max(sell2,prices[i]-buy2)
        return sell2
        