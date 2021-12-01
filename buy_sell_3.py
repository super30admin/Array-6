# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buy=[inf for i in range(k+1)]
        sell=[0 for i in range(k+1)]
        for i in prices:
            for j in range(k):
                if j>0:
                    buy[j]=min(buy[j],i-sell[j-1])
                else:
                    buy[j]=min(buy[j],i)
                sell[j]=max(sell[j],i-buy[j])
                
        return sell[k-1]
        