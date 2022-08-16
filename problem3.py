# Problem3: Buy and Sell Stock at Best Time IV

# // Time Complexity : O(N*k)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if k==0: return 0
        buy=[float('infinity')]*k
        sell=[0]*k
        
        for i in prices:
            for j in range(k):
                if j>0:
                    buy[j] = min(buy[j], i-sell[j-1])
                else:
                    buy[j] = min(buy[j], i)
 
                sell[j]=max(sell[j], i-buy[j])
        return sell[-1]
        