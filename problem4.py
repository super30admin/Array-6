# Problem3: Buy and Sell Stock at Best Time with cooldown

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices)<2: return 0
        buy=[0]*len(prices)
        sell = [0]*len(prices)
        buy[0]=-prices[0]
        buy[1]=max(buy[0],-prices[1])
        sell[1]=max(0,prices[1]+buy[0])
        
        i=2
        while i<len(prices):
            buy[i] = max(buy[i-1],sell[i-2]-prices[i])
            sell[i] = max(sell[i-1], prices[i]+buy[i-1])
            i+=1
        return sell[-1]
        