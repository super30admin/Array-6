#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1, buy2, sell1, sell2 = float("inf"), float("inf"), 0, 0
        if not prices:
            return 0
        for i in range(len(prices)):
            buy1 = min(buy1, prices[i])
            sell1 = max(sell1, prices[i]-buy1)

            buy2 = min(buy2, prices[i]-sell1)
            sell2 = max(sell2, prices[i]-buy2)

        return sell2
