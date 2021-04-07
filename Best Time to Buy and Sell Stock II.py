#time: O(n)
#space: O(1)

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if(prices==None or len(prices)==0):
            return 0
        maxprofit=0
        for i in range(len(prices)-1):
            maxprofit += max(prices[i+1]-prices[i], 0)
        return maxprofit
        