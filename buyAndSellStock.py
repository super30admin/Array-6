# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxProfit(self, arr: List[int]) -> int:
        maxProfit = 0
        currProfit = 0
        
        if not arr:
            return maxProfit

        #values at the index
        curr = arr[0]
        
        #one pass for loop
        for i in range(len(arr)):
            if arr[i] < curr:
                curr = arr[i]
            elif arr[i] > curr:
                currProfit =  arr[i] - curr
                maxProfit= max(maxProfit, currProfit)

        return maxProfit