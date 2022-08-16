# Problem2: Buy and Sell Stock at Best Time III
# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1=buy2=float('infinity')
        sell1=sell2=0
        
        for i in prices:
            buy1 = min(buy1, i)                 #first buy should be at the minimum number you find first
            sell1 = max(sell1, i-buy1)          #first sell is the difference between the current number and the first buy
            buy2 = min(buy2, i-sell1)           #second buy should be the second minimum minus the profit you gained from the first sell
            sell2=max(sell2, i-buy2)            #second sell should be the max of second profit and the difference between the current number and the second buy with the profits
        return sell2