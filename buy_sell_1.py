# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
       
    def maxProfit(self, prices: List[int]) -> int:
        minn=inf
        profit=-inf
        for i in prices:
            minn=min(minn,i)
            profit=max(profit,i-minn)
        return profit
            
        