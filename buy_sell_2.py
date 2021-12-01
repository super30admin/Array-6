# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1=prices[0]
        sell1=prices[0]-buy1
        buy2=prices[0]-sell1
        sell2=prices[0]-buy2
        for i in prices:
            buy1=min(buy1,i)
            sell1=max(sell1,i-buy1)
            buy2=min(buy2,i-sell1)
            sell2=max(sell2,i-buy2)
        return sell2
            