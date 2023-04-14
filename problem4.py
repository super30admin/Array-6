#time O(N)
#space O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n=len(prices)
        if n<2:
            return 0
        buy,sell=[0]*n,[0]*n
        buy[0]= -prices[0]

        for i in range(1,n):
            buy[i]=max (buy[i-1],(sell[i-2] if i>=2 else 0) -prices[i])
            sell[i]=max(sell[i-1],buy[i-1]+prices[i])
        return sell[-1]
            