#Time Complexity : O(n)
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mini, maxi = float("inf"), float("-inf")
        if not prices:
            return 0
        for i in range(len(prices)):
            mini = min(mini, prices[i])
            maxi = max(maxi, prices[i]-mini)

        return maxi
