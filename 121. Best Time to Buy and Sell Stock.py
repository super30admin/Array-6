#Time: O(n)
#space: O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy=prices[0]
        sell=-1
        for curr in prices:
            buy= min(buy,curr)
            sell= max(sell, curr-buy)
        return sell
