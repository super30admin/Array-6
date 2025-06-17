# Time Complexity : O(n)
# Space Complexity : O(n)

from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        self.memo = [[-1 for _ in range(2)] for _ in range(len(prices))]
        return self.helper(prices, 0, 0)

    def helper(self, prices, i, flag):
        if i >= len(prices):
            return 0

        if self.memo[i][flag] != -1:
            return self.memo[i][flag]

        if flag == 0:
            case1 = self.helper(prices, i+1, flag)
            case2 = -prices[i] + self.helper(prices, i+1, 1)
            ret = max(case1, case2)
            self.memo[i][0] = ret
            return ret
        else:
            case3 = self.helper(prices, i+1, 1)
            case4 = prices[i] + self.helper(prices, i+2, 0)
            ret = max(case3, case4)
            self.memo[i][1] = ret
            return ret