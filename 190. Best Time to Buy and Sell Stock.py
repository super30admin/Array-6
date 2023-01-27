class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minimum = prices[0]
        maximum = 0

        for i in range(1, len(prices)):
            maximum = max(maximum, prices[i] - minimum)
            minimum = min(minimum, prices[i])

        return maximum

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
