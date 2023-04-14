#time O(N)
#space O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices)==0:
            return 0
        else:
            low=float('inf')
            profit=0
            for i in prices:
                if i>low:
                    profit=max(profit,i-low)
                else:
                    low=i
        return profit