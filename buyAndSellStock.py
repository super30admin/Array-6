class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # T: O(n), S: O(1)
        l, r = 0, 1
        res = 0

        while r < len(prices):
            if prices[r] > prices[l]:
                profit = prices[r] - prices[l]
                res = max(res, profit)
            else:
                l = r
            r += 1

        return res
