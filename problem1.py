# Problem1: Buy and Sell Stock at Best Time


# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mini=float('infinity')
        res=0
        for i in prices:
            if i<mini:          #set the lowest price as mini
                mini=i
            else:
                diff = i-mini       #find the difference every time you find a price greater than mini
                res=max(diff, res)
        return res
        